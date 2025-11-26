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
import javax.swing.border.EmptyBorder;

public class EmailIncorreto extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public EmailIncorreto() {
        setTitle("Email Inválido");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 420, 120);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 234));
        this.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(207, 114, 116), 3));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Formato de email inválido");
        lblNewLabel.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(108, 26, 330, 28);
        contentPane.add(lblNewLabel);
        
        JLabel lblExemplo = new JLabel("Exemplo: usuario@dominio.com");
        lblExemplo.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblExemplo.setBounds(108, 51, 330, 28);
        contentPane.add(lblExemplo);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(EmailIncorreto.class.getResource("/imgs/EmailInvalido.png")));
        lblNewLabel_1.setBounds(23, 11, 63, 70);
        contentPane.add(lblNewLabel_1);

        JButton btnOK = new JButton("OK");
        btnOK.setForeground(new Color(255, 245, 234));
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnOK.setBackground(new Color(207, 114, 116));
        btnOK.setBounds(183, 81, 53, 28);
        btnOK.setFocusPainted(false);
        contentPane.add(btnOK);
    }
    
    public static void mostrar() {
        EmailIncorreto frame = new EmailIncorreto();
        frame.setVisible(true);
    }
}
