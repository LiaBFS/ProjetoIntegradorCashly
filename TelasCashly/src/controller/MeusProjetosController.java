package controller;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Projeto;
import model.ProjetoDAO;
import view.TelaInicio;
import view.TelaInternaCriar;
import view.TelaInternaInicial;
import view.TelaInternaProjeto;
import view.TelaInternaProjetos;

public class MeusProjetosController {

	
	private TelaInternaProjetos telaInternaProjetos;
	private TelaInicio telaInicio;
	private TelaInternaInicial telaInternaInicial;
	
	private ProjetoDAO projetoDAO;
	
	
	
	public MeusProjetosController(TelaInternaProjetos telaInternaProjetos, ProjetoDAO projetoDAO, TelaInicio telaInicio) {
		
		this.telaInternaProjetos = telaInternaProjetos;
		this.projetoDAO = projetoDAO;
		this.telaInicio = telaInicio;
		
		
		List<Projeto> lista = projetoDAO.listarProjetos();
		
		for (Projeto projeto : lista) {
			JPanel p = telaInternaProjetos.adicionarPainelProjeto(projeto);
			buscarProjeto(p);
		}
		
		
		}
	
	
	public void abrirTelaProjeto() {
		TelaInternaProjeto tela = new TelaInternaProjeto();
		ProjetoController controller = new ProjetoController(tela, projetoDAO);
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
	
	public void buscarProjeto(JPanel p) {
		
		//System.out.println("#######################################################");
		MouseAdapter listener = new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            abrirTelaProjeto();
	        	System.out.println("#######################################################");
	           // JButton B = (JButton) p.getComponent(0);
	    		//System.out.println("entrou"+B.getText());
	        }

	        @Override
	        public void mouseEntered(MouseEvent e) {
	        	p.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	        	//p.setBackground(/img);
	        	//mudar a imagem quando o mouse passa aqui
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	        	
	        	//voltar pra img original
	        }
	    };
	    
//	    p.addMouseListener(listener);
	    addMouseListenerRecursively(p, listener);
	}
	
	
}
