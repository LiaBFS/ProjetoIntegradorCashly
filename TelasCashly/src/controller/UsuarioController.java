package controller;

import javax.swing.JOptionPane;

import model.Sessao;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaApresentacao;
import view.TelaInternaPerfil;

public class UsuarioController {
	
    private TelaInternaPerfil tela;
    
    private InicioController inicioController;
    
    
    private Usuario usuario;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
   

   
    public UsuarioController(TelaInternaPerfil tela, Usuario usuario, InicioController controller) {
        this.tela = tela;
        this.usuario = usuario;
        this.inicioController = controller;
        
        inicializar();
        

    }
 
    
    private void inicializar() {
    	
    	
        // Preenche os textFields com os dados já cadastrados
    	
        tela.getTfNome().setText(usuario.getNome());
        tela.getTfEmail().setText(usuario.getEmail());

        
        tela.getBtnEditarNome().addActionListener(e -> editarNome());
        tela.getBtnEditarEmail().addActionListener(e -> editarEmail());
        tela.getBtnExcluirPerfil().addActionListener(e -> excluirPerfil());
        tela.getBtnSair().addActionListener(e -> logoff());
    }
    
    
    
    private void logoff() {
		
    	int opcao = JOptionPane.showConfirmDialog(
    	        null,
    	        "Deseja realmente sair da sua conta?",
    	        "Confirmar Logoff",
    	        JOptionPane.YES_NO_OPTION
    	    );

    	    if (opcao == JOptionPane.YES_OPTION) {
    	        
    	    	Sessao.setUsuarioLogado(null);
    	    	TelaApresentacao telaApresentacao = new TelaApresentacao();
    			ApresentacaoController apresentacaoController = new ApresentacaoController(telaApresentacao);
    			apresentacaoController.iniciarApresentacao();
    			inicioController.sair();
   
    	    }
		
	}


    private void excluirPerfil() {
        Object[] opcoes = {"Continuar", "Cancelar"};

        int resposta = JOptionPane.showOptionDialog(
                null,
                "Você realmente quer excluir seu perfil?",
                "Confirmação de Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                opcoes,
                opcoes[1]
        );

        if (resposta != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
            return;
        }

    
        boolean excluido = usuarioDAO.excluirUsuario(usuario.getId());

        if (excluido) {
            JOptionPane.showMessageDialog(null, "Perfil excluído com sucesso.");
            
            Sessao.setUsuarioLogado(null);
            TelaApresentacao tela = new TelaApresentacao(); 
            ApresentacaoController apresentacao = new ApresentacaoController(tela);
            apresentacao.iniciarApresentacao();
            inicioController.sair();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir perfil.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    

   
    private void editarNome() {
        String novoNome = tela.getTfNome().getText().trim();

        if (novoNome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um novo nome.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (novoNome.length() < 3) {
            JOptionPane.showMessageDialog(null, "O nome deve ter pelo menos 3 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            tela.getTfNome().setText(usuario.getNome()); 
            return;
        }

        usuario.setNome(novoNome);
        usuarioDAO.atualizarNomeUsuario(usuario);

        JOptionPane.showMessageDialog(null, "Nome de Usuário atualizado com sucesso");
    }

    
    
    
    
    
    private void editarEmail() {
        String novoEmail = tela.getTfEmail().getText().trim();

        if (novoEmail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um novo email.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

      
        if (!novoEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(null, "Formato de email inválido. Exemplo: usuario@dominio.com", "Erro de Atualização", JOptionPane.ERROR_MESSAGE);
            tela.getTfEmail().setText(usuario.getEmail()); 
            return;
        }

        usuario.setEmail(novoEmail);
        usuarioDAO.atualizarEmailUsuario(usuario);

        JOptionPane.showMessageDialog(null, "Email atualizado com sucesso!");
    }
}