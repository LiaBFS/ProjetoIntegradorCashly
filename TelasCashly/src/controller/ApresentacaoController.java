package controller;

import view.TelaApresentacao;
import view.TelaCredenciais;

public class ApresentacaoController {

	private TelaApresentacao telaApresentacao;
	public ApresentacaoController(TelaApresentacao telaApresentacao) {
		this.telaApresentacao = telaApresentacao;
		
		this.telaApresentacao.getBtnCadastrar().addActionListener(e -> abrirTelaCadastro());
		this.telaApresentacao.getBtnFacaProjetos().addActionListener(e -> abrirTelaCadastro());
		this.telaApresentacao.getBtnGrafica().addActionListener(e -> abrirTelaCadastro());
		this.telaApresentacao.getBtnRecebaAvisos().addActionListener(e -> abrirTelaCadastro());
		this.telaApresentacao.getBtnPainelCentral().addActionListener(e -> abrirTelaCadastro());

		this.telaApresentacao.getBtnLogin().addActionListener(e -> abrirTelaLogin());
				
	}
	public void iniciar() {
		this.telaApresentacao.setVisible(true);
		
	}
	
    private void abrirTelaCadastro() {
        this.telaApresentacao.dispose(); // Fecha a tela atual
        
        
        
        TelaCredenciais tela = new TelaCredenciais("cadastro"); // Abre direto no cadastro
        CredenciaisController credenciais = new CredenciaisController(tela);
        credenciais.iniciarCadastro();
    }

    private void abrirTelaLogin() {
    	this.telaApresentacao.dispose(); // Fecha a tela atual
    	
    	  TelaCredenciais tela = new TelaCredenciais("login"); // Abre direto no cadastro
          CredenciaisController credenciais = new CredenciaisController(tela);
          credenciais.iniciarCadastro();
    }

}
