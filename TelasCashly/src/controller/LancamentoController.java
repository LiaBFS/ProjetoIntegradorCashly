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
		
		telaLancamento.getbtnCancelar().addActionListener(e -> cancelarLanamentoDialog());
		telaLancamento.getbtnAdicionar().addActionListener(e -> AdicionarLanamentoDialog());

		telaLancamento.setVisible(true);
		
		
	}
	private Object AdicionarLanamentoDialog() {
		// TODO Auto-generated method stub
		return null;
	}
	private Object cancelarLanamentoDialog() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
