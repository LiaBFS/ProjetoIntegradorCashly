package controller;

import javax.swing.JOptionPane;

import model.Sessao;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaApresentacao;
import view.TelaCredenciais;
import view.TelaInicio;
import view.TelaInternaCadastro;
import view.TelaInternaLogin;

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
	            
	        	JOptionPane.showMessageDialog(null, "Todos os campos do Login são obrigatórios.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        // cria objeto usuario com email e senha
	        
	        Usuario usuarioLogin=null;
			try {
				usuarioLogin = new Usuario(0, null, email, senha, null, null);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	        
	        UsuarioDAO usuarioDAO = new UsuarioDAO();
	        Usuario usuarioAutenticado = usuarioDAO.pesquisarUsuariosPorEmailSenha(usuarioLogin);

	     
	        if (usuarioAutenticado != null) {
	            Sessao.setUsuarioLogado(usuarioAutenticado);
	            abrirTelaInicial();
	        } else {
	            JOptionPane.showMessageDialog(null, "E-mail e/ou senha incorretos. Tente Novamente.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
	            
	            
	            
	            this.telaLogin.resetarTxtEmail() ; 
	            this.telaLogin.resetarTxtSenha();
	            
		            }
		
	}

	public void confereCadastro() {
		
		String nome = this.telaCadastro.getTxtNome().getText();
		String email = this.telaCadastro.getTxtEmail().getText();
		char[] senhaChars = this.telaCadastro.getTxtSenha().getPassword();
        String senha = new String(senhaChars);
        
						
		if (nome.equals(this.telaCadastro.getPlaceholderUsuario()) || email.equals(this.telaCadastro.getPlaceholderEmail()) || senha.equals(this.telaCadastro.getPlaceholderSenha())|| nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos os campos do Cadastro são obrigatórios.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if(nome.length() < 3) {
			JOptionPane.showMessageDialog(null, "Crie um usuário contendo no mínimo 3 dígitos.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
			
			return;
		}
		
		if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
		    JOptionPane.showMessageDialog(null, "Formato de email inválido. Exemplo: usuario@dominio.com", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
		    this.telaCadastro.getTxtEmail().setText(this.telaCadastro.getPlaceholderEmail());
		    return;
		}
		
		if(senha.length() < 8 || senha.length() > 30) {
			JOptionPane.showMessageDialog(null, "Crie uma senha contendo de 8 a 30 dígitos.", "Erro de Senha", JOptionPane.ERROR_MESSAGE);
			this.telaCadastro.getTxtSenha().setText(this.telaCadastro.getPlaceholderSenha());
			return;
		}
		
		
		model.Usuario novoUsuario = new model.Usuario();
        novoUsuario.setNome(this.telaCadastro.getTxtNome().getText());
        novoUsuario.setEmail(this.telaCadastro.getTxtEmail().getText());
        try {
			novoUsuario.setSenha(senha);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        usuarioDAO.adicionarUsuario(novoUsuario);
        
        mostrarTela("login");
		
		
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
	
	  // Método para trocar entre telas
    public void mostrarTela(String nomeTela) {
        this.tela.getCard().show(this.tela.getPainelPrincipal(), nomeTela);
    }
    
    
    private void abrirTelaInicial() {
		this.tela.dispose(); // Fecha a tela atual
        TelaInicio t = new TelaInicio(); // Abre a tela de cadastro
        InicioController inicio = new InicioController(t);
        inicio.abrirTela();
    }


}
