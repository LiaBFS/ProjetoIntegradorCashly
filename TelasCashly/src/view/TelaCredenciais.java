package view;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.UsuarioDAO;

public class TelaCredenciais extends JFrame {
    private JPanel painelPrincipal;
    private TelaInternaCadastro telaCadastro;
    private TelaInternaLogin telaLogin;
    private CardLayout card;
    
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public TelaCredenciais(String telaInicial) { // << ADICIONADO
        setTitle("Tela de Credenciais");
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 700));

        // Layout de cartões
        card = new CardLayout();
        painelPrincipal = new JPanel(card);

        // Cria os painéis internos
        telaCadastro = new TelaInternaCadastro(this, usuarioDAO);
        telaLogin = new TelaInternaLogin(this, usuarioDAO);

        // Adiciona ao CardLayout
        painelPrincipal.add(telaLogin, "login");
        painelPrincipal.add(telaCadastro, "cadastro");

        add(painelPrincipal);

        // Mostra a tela inicial passada no construtor
        mostrarTela(telaInicial);
    }

    // Método para trocar entre telas
    public void mostrarTela(String nomeTela) {
        card.show(painelPrincipal, nomeTela);
    }

    public static void main(String[] args) {
        TelaCredenciais tela = new TelaCredenciais("login"); // default
        tela.setVisible(true);
    }
}
