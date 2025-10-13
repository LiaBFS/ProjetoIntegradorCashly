package controller;

import java.util.ArrayList;

import model.Projeto;
import model.ProjetoDAO;
import view.TelaInternaCriar;
import view.TelaInternaInicial;
import view.TelaInternaProjetos;

public class MeusProjetosController {

	
	private TelaInternaProjetos telaInternaProjetos;
	private TelaInternaInicial telaInternaInicial;
	
	private ProjetoDAO projetoDAO;
	
	
	public MeusProjetosController(TelaInternaProjetos telaInternaProjetos, ProjetoDAO projetoDAO) {
		
		this.telaInternaProjetos = telaInternaProjetos;
		this.projetoDAO = projetoDAO;
		
		
		ArrayList<Projeto> lista = projetoDAO.listarProjetos();
		
		for (Projeto projeto : lista) {
			telaInternaProjetos.adicionarPainelProjeto(projeto);
		}
		
		
		
		}
}
