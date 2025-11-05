package controller;

import model.ProjetoDAO;
import view.TelaInternaLancamentos;
import view.TelaInternaProjeto;

public class ProjetoController {
	
	TelaInternaProjeto tela = new TelaInternaProjeto();
	
	ProjetoDAO projetoDAO;
	
	public ProjetoController(TelaInternaProjeto tela, ProjetoDAO projetoDAO) {
		
		this.tela = tela;
		this.projetoDAO = projetoDAO;
		
		this.tela.getBtnAdicionarLancamento().addActionListener(e -> abrirPopUpLancamento());
		
	}

	private void abrirPopUpLancamento() {
		
		System.out.println("ABRIU ###############################");
		
		TelaInternaLancamentos tela = new TelaInternaLancamentos();
		LancamentoController controller = new LancamentoController(tela);
		
		tela.setVisible(true);
		
	}

}
