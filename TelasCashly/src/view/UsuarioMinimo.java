package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UsuarioMinimo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public UsuarioMinimo() {
        setTitle("Usuário Inválido");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 420, 120);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 234));
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.RED, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Usuário Inválido");
        lblTitulo.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setBounds(110, 26, 330, 28);
        contentPane.add(lblTitulo);
        
        JLabel lblMensagem = new JLabel("O nome deve ter no mínimo 3 caracteres");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblMensagem.setBounds(110, 51, 330, 28);
        contentPane.add(lblMensagem);

        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(UsuarioMinimo.class.getResource("/imgs/EmailInvalido.png")));
        lblIcone.setBounds(24, 11, 63, 70);
        contentPane.add(lblIcone);

        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnOK.setBackground(new Color(207, 114, 116));
        btnOK.setBounds(180, 85, 53, 28);
        contentPane.add(btnOK);
    }
    
    public static void mostrar() {
        UsuarioMinimo frame = new UsuarioMinimo();
        frame.setVisible(true);
    }
}