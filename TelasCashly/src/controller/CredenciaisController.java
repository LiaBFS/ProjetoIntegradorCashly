package controller;

import java.text.SimpleDateFormat;
import model.Projeto;
import model.ProjetoDAO;
import model.Sessao;
import model.Usuario;
import model.UsuarioDAO;
import view.*;

public class CredenciaisController {

	private TelaCredenciais tela;
	private TelaInternaCadastro telaCadastro;
	private TelaInternaLogin telaLogin;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
	public CredenciaisController(TelaCredenciais tela) {
		this.tela = tela;
        telaCadastro = new TelaInternaCadastro(this.tela);
        telaLogin = new TelaInternaLogin(this.tela); 
		 
        this.tela.getPainelPrincipal().add(telaLogin, "login");
        this.tela.getPainelPrincipal().add(telaCadastro, "cadastro");
        
        this.telaCadastro.getBtnLogin().addActionListener(e -> mostrarTela("login"));
        this.telaCadastro.getBtnIrProLogin().addActionListener(e -> mostrarTela("login"));
        this.telaCadastro.getBtnInicio().addActionListener(e -> abrirTelaApresentacao());
        this.telaCadastro.getBtnCadastrar().addActionListener(e -> confereCadastro());
        
        this.telaLogin.getBtnCadastrar().addActionListener(e -> mostrarTela("cadastro"));
        this.telaLogin.getBtnIrCadastro().addActionListener(e -> mostrarTela("cadastro"));
        this.telaLogin.getBtnInicio().addActionListener(e -> abrirTelaApresentacao());
        this.telaLogin.getBtnIniciarSessao().addActionListener(e -> iniciarSessao());
	}
	
	private void iniciarSessao() {
		String email = this.telaLogin.getTxtEmail().getText().trim();
        char[] senhaChars = this.telaLogin.getTxtSenha().getPassword();
        String senha = new String(senhaChars);
        
        if (email.isEmpty() || email.equals(this.telaLogin.getPlaceholderEmail()) ||
            senha.isEmpty() || senha.equals(this.telaLogin.getPlaceholderSenha())) {
            
        	CamposObrigatoriosLogin.mostrar(); // ✅ SUBSTITUÍDO
            return;
        }

        Usuario usuarioLogin = null;
		try {
			usuarioLogin = new Usuario(0, null, email, senha, null, null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.pesquisarUsuariosPorEmailSenha(usuarioLogin);

        if (usuarioAutenticado != null) {
            Sessao.setUsuarioLogado(usuarioAutenticado);
            abrirTelaInicial();
        } else {
            LoginIncorreto.mostrar(); 
            this.telaLogin.resetarTxtEmail(); 
            this.telaLogin.resetarTxtSenha();
        }
	}

	public void confereCadastro() {
		String nome = this.telaCadastro.getTxtNome().getText();
		String email = this.telaCadastro.getTxtEmail().getText();
		char[] senhaChars = this.telaCadastro.getTxtSenha().getPassword();
        String senha = new String(senhaChars);
        
		if (nome.equals(this.telaCadastro.getPlaceholderUsuario()) || 
		    email.equals(this.telaCadastro.getPlaceholderEmail()) || 
		    senha.equals(this.telaCadastro.getPlaceholderSenha()) || 
		    nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
			
			CamposObrigatoriosCadastro.mostrar(); // ✅ SUBSTITUÍDO
	        return;
	    }
		
		if(nome.length() < 3) {
			UsuarioMinimo.mostrar(); // ✅ SUBSTITUÍDO
			return;
		}
		
		if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
		    EmailIncorreto.mostrar(); // ✅ SUBSTITUÍDO
		    this.telaCadastro.getTxtEmail().setText(this.telaCadastro.getPlaceholderEmail());
		    return;
		}
		
		if(senha.length() < 8 || senha.length() > 30) {
			SenhaInvalida.mostrar(); // ✅ SUBSTITUÍDO
			this.telaCadastro.getTxtSenha().setText(this.telaCadastro.getPlaceholderSenha());
			return;
		}
		
		model.Usuario novoUsuario = new model.Usuario();
        novoUsuario.setNome(this.telaCadastro.getTxtNome().getText());
        novoUsuario.setEmail(this.telaCadastro.getTxtEmail().getText());
        try {
			novoUsuario.setSenha(senha);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        
        usuarioDAO.adicionarUsuario(novoUsuario);
        
        UsuarioCadastrado.mostrar();
        
        mostrarTela("login");
        this.telaCadastro.getTxtEmail().setText(this.telaCadastro.getPlaceholderEmail());
        this.telaCadastro.getTxtSenha().setText(this.telaCadastro.getPlaceholderSenha());
        this.telaCadastro.getTxtNome().setText(this.telaCadastro.getPlaceholderUsuario());
        
	}
	
	public void iniciarLogin() {
		this.tela.setVisible(true);
		mostrarTela("login");
	}
	
	public void iniciarCadastro() {
		this.tela.setVisible(true);
		mostrarTela("cadastro");
	}
	
	private void abrirTelaApresentacao() {
		this.tela.dispose();
		TelaApresentacao tela = new TelaApresentacao(); 
        ApresentacaoController apresentacao = new ApresentacaoController(tela);
        apresentacao.iniciarApresentacao();
	}
	
    public void mostrarTela(String nomeTela) {
        this.tela.getCard().show(this.tela.getPainelPrincipal(), nomeTela);
    }
    
    private void abrirTelaInicial() {
		this.tela.dispose();
        TelaInicio t = new TelaInicio();
        InicioController inicio = new InicioController(t);
        inicio.abrirTela();
    }
}
