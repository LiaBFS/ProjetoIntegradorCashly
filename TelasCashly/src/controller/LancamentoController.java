package controller;

import model.ProjetoDAO;
import view.TelaInternaLancamentos;
import view.TelaInternaProjeto;

public class LancamentoController {
	
	private TelaInternaProjeto tela;
	private ProjetoDAO projetoDAO;
	private TelaInternaLancamentos telaLancamentos;
	private TelaInternaLancamentos telaLancamento;
	public LancamentoController(TelaInternaProjeto tela, ProjetoDAO projetoDAO,
			TelaInternaLancamentos telaLancamentos) {
		this.tela = tela;
		this.projetoDAO = projetoDAO;
		this.telaLancamentos = telaLancamentos;
		
		
		this.tela.getBtnAdicionarLancamento().addActionListener(e -> abrirTelaLancamentos());
		
		
	}
	private void  abrirTelaLancamentos() {
		telaLancamento = new TelaInternaLancamentos();
		
		telaLancamento.getCancelButton().addActionListener(e -> cancelarLanamentoDialog());
		telaLancamento.getOkButton().addActionListener(e -> okLanamentoDialog());

		telaLancamento.setVisible(true);
		
		
	}
	private Object okLanamentoDialog() {
		// TODO Auto-generated method stub
		return null;
	}
	private Object cancelarLanamentoDialog() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
