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

public class CamposObrigatoriosCadastro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public CamposObrigatoriosCadastro() {
        setTitle("Campos Obrigatórios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 400, 120);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 234));
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.RED, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Campos Obrigatórios");
        lblTitulo.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setBounds(109, 28, 310, 28);
        contentPane.add(lblTitulo);
        
        JLabel lblMensagem = new JLabel("Preencha todos os campos do Cadastro");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblMensagem.setBounds(109, 53, 310, 28);
        contentPane.add(lblMensagem);

        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(CamposObrigatoriosCadastro.class.getResource("/imgs/EmailInvalido.png")));
        lblIcone.setBounds(23, 11, 63, 70);
        contentPane.add(lblIcone);

        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnOK.setBackground(new Color(207, 114, 116));
        btnOK.setBounds(170, 85, 53, 28);
        contentPane.add(btnOK);
    }
    
    public static void mostrar() {
        CamposObrigatoriosCadastro frame = new CamposObrigatoriosCadastro();
        frame.setVisible(true);
    }
}
