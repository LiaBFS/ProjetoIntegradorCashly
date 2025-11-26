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

public class LoginIncorreto extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public LoginIncorreto() {
        setTitle("Login Incorreto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 380, 120);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 234));
        this.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(207, 114, 116), 3));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Login Incorreto");
        lblTitulo.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setBounds(115, 25, 290, 28);
        contentPane.add(lblTitulo);
        
        JLabel lblMensagem = new JLabel("E-mail e/ou senha incorretos");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblMensagem.setBounds(115, 50, 290, 28);
        contentPane.add(lblMensagem);

        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(LoginIncorreto.class.getResource("/imgs/EmailInvalido.png")));
        lblIcone.setBounds(23, 11, 63, 70);
        contentPane.add(lblIcone);

        JButton btnOK = new JButton("OK");
        btnOK.setForeground(new Color(255, 245, 234));
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnOK.setBackground(new Color(207, 114, 116));
        btnOK.setBounds(163, 81, 53, 28);
        btnOK.setFocusPainted(false);
        contentPane.add(btnOK);
    }
    
    public static void mostrar() {
        LoginIncorreto frame = new LoginIncorreto();
        frame.setVisible(true);
    }
}
