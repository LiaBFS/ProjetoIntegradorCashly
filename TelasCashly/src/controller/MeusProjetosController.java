package controller;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.Projeto;
import model.ProjetoDAO;
import view.ConfirmacaoExclusao;
import view.ProjetoExcluido;
import view.TelaInicio;
import view.TelaInternaInicial;
import view.TelaInternaProjeto;
import view.TelaInternaProjetos;

public class MeusProjetosController {
	
	private TelaInternaProjetos telaInternaProjetos;
	private TelaInicio telaInicio;
	private TelaInternaInicial telaInternaInicial;
	private ProjetoDAO projetoDAO;
	
	
	public MeusProjetosController(ProjetoDAO projetoDAO, TelaInicio telaInicio) {
		this.projetoDAO = projetoDAO;
		this.telaInicio = telaInicio;
	}
	
	public MeusProjetosController(TelaInternaProjetos telaInternaProjetos, ProjetoDAO projetoDAO, TelaInicio telaInicio) {
		this.telaInternaProjetos = telaInternaProjetos; 
		this.projetoDAO = projetoDAO;
		this.telaInicio = telaInicio;
		
		carregarProjetos();
	}
	
	/**
	 * Método para carregar os projetos e decidir qual card mostrar
	 */
	public void carregarProjetos() {
		List<Projeto> lista = projetoDAO.listarProjetos();
		
		if (lista == null || lista.isEmpty()) {
			telaInternaProjetos.mostrarTelaSemProjetos();
		} else {
			telaInternaProjetos.resetarLinhas(); 
			
			for (Projeto projeto : lista) {
				JPanel painelProjeto = telaInternaProjetos.adicionarPainelProjeto(projeto);
				
				painelProjeto.putClientProperty("projeto", projeto);
				
				buscarProjeto(painelProjeto);
				configurarBotaoExcluir(painelProjeto, projeto);
			}
			
			telaInternaProjetos.mostrarTelaComProjetos();
		}
	}
	
	/**
	 * Configura o botão de excluir do painel do projeto
	 */
	private void configurarBotaoExcluir(JPanel painelProjeto, Projeto projeto) {
		JButton btnExcluir = telaInternaProjetos.getBtnExcluirDoPainel(painelProjeto);
		
		if (btnExcluir != null) {
			// Remove listeners antigos para evitar duplicação
			for (var listener : btnExcluir.getActionListeners()) {
				btnExcluir.removeActionListener(listener);
			}
			
			btnExcluir.addActionListener(e -> {
				excluirProjeto(projeto);
			});
		}
	}
	
	/**
	 * Método para excluir um projeto
	 */
	private void excluirProjeto(Projeto projeto) {
		JFrame frameParent = (JFrame) SwingUtilities.getWindowAncestor(telaInternaProjetos);
		
		// Mostrar diálogo de confirmação personalizado
		boolean confirmado = ConfirmacaoExclusao.mostrar(frameParent, projeto.getNome());
		
		if (!confirmado) {
			return;
		}
		
		boolean excluido = projetoDAO.excluirProjeto(projeto.getId());
		
		if (excluido) {
			ProjetoExcluido.mostrar(frameParent);
			
			// Recarregar a lista de projetos
			carregarProjetos();
		} else {
			JOptionPane.showMessageDialog(
					telaInternaProjetos,
					"Erro ao excluir o projeto. Tente novamente.",
					"Erro",
					JOptionPane.ERROR_MESSAGE
			);
		}
	}
	
	public void abrirTelaProjeto(Projeto projeto) {
		TelaInternaProjeto tela = new TelaInternaProjeto();
		ProjetoController controller = new ProjetoController(tela, projetoDAO, projeto);
		
		this.telaInicio.atualizarPainel(tela);
		this.telaInicio.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.telaInicio.pack();
	}
	
	private void addMouseListenerRecursively(Component comp, MouseAdapter listener) {
		comp.addMouseListener(listener);
		if (comp instanceof java.awt.Container) {
			for (Component child : ((java.awt.Container) comp).getComponents()) {
				addMouseListenerRecursively(child, listener);
			}
		}
	}
	
	public void buscarProjeto(JPanel painelProjeto) {
		MouseAdapter listener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Verificar se o clique foi no botão de excluir
				Component componenteClicado = e.getComponent();
				JButton btnExcluir = telaInternaProjetos.getBtnExcluirDoPainel(painelProjeto);
				
				// Se clicou no botão de excluir ou em seus componentes, não abrir o projeto
				if (componenteClicado == btnExcluir || SwingUtilities.isDescendingFrom(componenteClicado, btnExcluir)) {
					return;
				}
				
				Projeto projetoClicado = (Projeto) painelProjeto.getClientProperty("projeto");
				
				if (projetoClicado != null) {
					System.out.println("Abrindo projeto: " + projetoClicado.getNome());
					abrirTelaProjeto(projetoClicado);
				} else {
					System.err.println("Erro: Projeto não encontrado no painel!");
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				painelProjeto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				painelProjeto.setCursor(Cursor.getDefaultCursor());
			}
		};
		
		addMouseListenerRecursively(painelProjeto, listener);
	}
}