package telas;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.*;

public class TelaCredenciais extends JFrame {
    private JPanel painelPrincipal;
    private TelaInternaCadastro telaCadastro;
    private TelaInternaLogin telaLogin;
    private CardLayout card;

    public TelaCredenciais() {
        setTitle("Tela de Credenciais");
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(950, 690));

        // Layout de cartões
        card = new CardLayout();
        painelPrincipal = new JPanel(card);

        // Cria os painéis internos
        TelaInternaCadastro telaCadastro = new TelaInternaCadastro(this);
        TelaInternaLogin  telaLogin = new TelaInternaLogin(this);

        // Adiciona ao CardLayout
        painelPrincipal.add(telaLogin, "login");
        painelPrincipal.add(telaCadastro, "cadastro");
        

        add(painelPrincipal);
        
        
    }

    // Método para trocar entre telas
    public void mostrarTela(String nomeTela) {
        card.show(painelPrincipal, nomeTela);
    }
    
   public static void main(String[] args) {
	
	   
	   TelaCredenciais tela = new TelaCredenciais();
	   tela.setVisible(true);
	   
   } 
}