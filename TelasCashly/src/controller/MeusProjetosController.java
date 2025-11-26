package controller;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Projeto;
import model.ProjetoDAO;
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
		
		// Listar e adicionar todos os projetos
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
			}
			
			telaInternaProjetos.mostrarTelaComProjetos();
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
				// Recuperar o projeto armazenado no painel
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