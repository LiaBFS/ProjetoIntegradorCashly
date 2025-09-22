package controller;

import model.UsuarioDAO;
import view.TelaCredenciais;
import view.TelaInternaCadastro;
import view.TelaInternaLogin;

public class CredenciaisController {

	private TelaCredenciais tela;
	private TelaInternaCadastro telaCadastro;
	private TelaInternaLogin telaLogin;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    
	public CredenciaisController(TelaCredenciais tela) {
		this.tela = tela;
		
		 // Cria os painéis internos
        telaCadastro = new TelaInternaCadastro(this.tela, usuarioDAO);
        telaLogin = new TelaInternaLogin(this.tela, usuarioDAO);
		  // Adiciona ao CardLayout
        this.tela.getPainelPrincipal().add(telaLogin, "login");
        this.tela.getPainelPrincipal().add(telaCadastro, "cadastro");

	}
	public void iniciarLogin() {
		this.tela.setVisible(true);
		mostrarTela("login");
		
	}
	public void iniciarCadastro() {
		this.tela.setVisible(true);
		mostrarTela("cadastro");
	}
	
	  // Método para trocar entre telas
    public void mostrarTela(String nomeTela) {
        this.tela.getCard().show(this.tela.getPainelPrincipal(), nomeTela);
    }


}
