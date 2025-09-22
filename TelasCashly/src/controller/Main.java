package controller;

import view.TelaApresentacao;

public class Main {

	public static void main(String[] args) {
		
		
		TelaApresentacao telaApresentacao = new TelaApresentacao();
		ApresentacaoController apresentacaoController = new ApresentacaoController(telaApresentacao);
		apresentacaoController.iniciarApresentacao();
	}

}
