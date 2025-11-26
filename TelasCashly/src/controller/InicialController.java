package controller;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import model.Projeto;
import model.ProjetoDAO;
import view.JPanelComBackground;
import view.TelaInicio;
import view.TelaInternaInicial;

public class InicialController {
	
	private TelaInternaInicial tela;
	private ProjetoDAO projetoDAO;


	

	public InicialController(TelaInternaInicial tela, MeusProjetosController controllerProjetos) {
		
		this.tela = tela;
		this.projetoDAO = new ProjetoDAO();

		JPanelComBackground painel = this.tela.getPanel();
		
		MouseAdapter listener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Projeto p = projetoDAO.buscarProjetoRecente();
				// Recuperar o projeto armazenado no painel
				//Projeto projetoClicado = (Projeto) painel.getClientProperty("projeto");
				
//				if (projetoClicado != null) {
//					System.out.println("Abrindo projeto: " + projetoClicado.getNome());
					controllerProjetos.abrirTelaProjeto(p);
//				} else {
					System.err.println("#####################################");
//				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				painel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				painel.setCursor(Cursor.getDefaultCursor());
			}
		};
		
		addMouseListenerRecursively(painel, listener);
		
	}

	private void addMouseListenerRecursively(Component comp, MouseAdapter listener) {
		comp.addMouseListener(listener);
		if (comp instanceof java.awt.Container) {
			for (Component child : ((java.awt.Container) comp).getComponents()) {
				addMouseListenerRecursively(child, listener);
			}
		}
	}

	public void colocarProjetoRecente() {
		
		ProjetoDAO projetoDAO = new ProjetoDAO();
	    Projeto projetoRecente = projetoDAO.buscarProjetoRecente();

	    
	    if (projetoRecente != null) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        String dataFormatada = sdf.format(projetoRecente.getDataCriacao());

	        tela.atualizarProjetoRecente(
	            projetoRecente.getNome(),
	            projetoRecente.getDescricao(),
	            dataFormatada
	        );
	    } else {
	        tela.atualizarProjetoRecente("Nenhum Projeto Cadastrado...", "Crie um Projeto para desbloquear a adição de Metas e visualização de Gráficos!", "-");
	    }
		
	}
	
	
	

}
