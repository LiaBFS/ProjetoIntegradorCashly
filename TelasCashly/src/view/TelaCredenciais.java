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
    

    public TelaCredenciais(String telaInicial) {
        setTitle("Tela de Credenciais");
        
        this.setUndecorated(true);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 700));

        // Layout de cartões
        card = new CardLayout();
        painelPrincipal = new JPanel(card);

       

      
        add(painelPrincipal);

        // Mostra a tela inicial passada no construtor
    }

  

    
    public CardLayout getCard() {
		return card;
	}

	public JPanel getPainelPrincipal() {
		return painelPrincipal;
	}
}
