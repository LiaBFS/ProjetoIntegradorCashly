package controller;

import javax.swing.JFrame;

import model.ProjetoDAO;
import view.TelaInternaEscolhaGrafico;
import view.TelaInternaInicial;
import view.TelaInternaLancamentos;
import view.TelaInternaProjeto;

public class ProjetoController {
	
	TelaInternaProjeto tela;
	TelaInternaInicial telaInicio;
	
	ProjetoDAO projetoDAO;
	
	public ProjetoController(TelaInternaProjeto tela, ProjetoDAO projetoDAO) {
		
		this.tela = tela;
		this.projetoDAO = projetoDAO;
		
		this.tela.getBtnAdicionarLancamento().addActionListener(e -> abrirPopUpLancamento());
		
	}

	private void abrirTelaEscolhaGrafico() {
		
		TelaInternaEscolhaGrafico tela = new TelaInternaEscolhaGrafico();
		GraficoController controller = new GraficoController(tela);
//		this.telaInicio.atualizarPainel(tela);
//		this.telaInicio.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		this.telaInicio.pack();	
		
		
	}

	private void abrirPopUpLancamento() {
		
		TelaInternaLancamentos tela = new TelaInternaLancamentos();
		LancamentoController controller = new LancamentoController(tela);
		
		tela.setVisible(true);
		
	}

}
