package controller;

import javax.swing.JOptionPane;

import model.Usuario;
import model.UsuarioDAO;
import view.TelaInternaPerfil;

public class UsuarioController {
    private TelaInternaPerfil tela;
    private Usuario usuario;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

   
    public UsuarioController(TelaInternaPerfil tela, Usuario usuario) {
        this.tela = tela;
        this.usuario = usuario;
        inicializar();
    }

    
    private void inicializar() {
    	
    	
        // Preenche os textFields com os dados já cadastrados
        tela.getTfNome().setText(usuario.getNome());
        tela.getTfEmail().setText(usuario.getEmail());

        
        tela.getBtnEditarNome().addActionListener(e -> editarNome());
        tela.getBtnEditarEmail().addActionListener(e -> editarEmail());
        tela.getBtnExcluirPerfil().addActionListener(e -> excluirPerfil());
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

        if (resposta == JOptionPane.YES_OPTION) {
            if (usuarioDAO.excluirUsuario(usuario.getId())) {
                JOptionPane.showMessageDialog(null, "Perfil excluído.");
               
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir perfil.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
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