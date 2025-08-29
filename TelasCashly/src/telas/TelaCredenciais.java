package telas;

import java.awt.CardLayout;
import javax.swing.*;

public class TelaCredenciais extends JFrame {
    private JPanel painelPrincipal;
    private TelaInternaCadastro telaCadastro;
    private TelaInternaLogin telaLogin;
    private CardLayout card;

    public TelaCredenciais() {
        setTitle("Tela de Credenciais");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout de cartões
        card = new CardLayout();
        painelPrincipal = new JPanel(card);

        // Cria os painéis internos
        telaCadastro = new TelaInternaCadastro(this);
        telaLogin = new TelaInternaLogin(this);

        // Adiciona ao CardLayout
        painelPrincipal.add(telaCadastro, "cadastro");
        painelPrincipal.add(telaLogin, "login");

        add(painelPrincipal);
    }

    // Método para trocar entre telas
    public void mostrarTela(String nomeTela) {
        card.show(painelPrincipal, nomeTela);
    }
}