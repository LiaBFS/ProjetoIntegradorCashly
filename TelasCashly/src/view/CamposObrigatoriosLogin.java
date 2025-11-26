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

public class CamposObrigatoriosLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public CamposObrigatoriosLogin() {
        setTitle("Campos Obrigatórios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 380, 120);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 234));
        this.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(207, 114, 116), 3));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Campos Obrigatórios");
        lblTitulo.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setBounds(107, 27, 290, 28);
        contentPane.add(lblTitulo);
        
        JLabel lblMensagem = new JLabel("Preencha todos os campos do Login");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblMensagem.setBounds(107, 53, 290, 28);
        contentPane.add(lblMensagem);

        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(CamposObrigatoriosLogin.class.getResource("/imgs/EmailInvalido.png")));
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
        CamposObrigatoriosLogin frame = new CamposObrigatoriosLogin();
        frame.setVisible(true);
    }
}