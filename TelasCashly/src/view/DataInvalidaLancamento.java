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

public class DataInvalidaLancamento extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public DataInvalidaLancamento() {
        setTitle("Data Inválida");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 420, 120);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 234));
        this.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(207, 114, 116), 3));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Data Inválida");
        lblTitulo.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setBounds(110, 26, 330, 28);
        contentPane.add(lblTitulo);
        
        JLabel lblMensagem = new JLabel("Use o formato dd/MM/yyyy (ex: 25/12/2024)");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblMensagem.setBounds(110, 51, 330, 28);
        contentPane.add(lblMensagem);

        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(DataInvalidaLancamento.class.getResource("/imgs/EmailInvalido.png")));
        lblIcone.setBounds(24, 11, 63, 70);
        contentPane.add(lblIcone);

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
        DataInvalidaLancamento frame = new DataInvalidaLancamento();
        frame.setVisible(true);
    }
}
