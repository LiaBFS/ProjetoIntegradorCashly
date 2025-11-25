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

public class PerfilEditadoNome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public PerfilEditadoNome() {
        setTitle("Nome Atualizado");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 380, 120);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 234));
        this.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(34, 139, 34), 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Nome Atualizado!");
        lblTitulo.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setBounds(106, 30, 290, 28);
        contentPane.add(lblTitulo);
        
        JLabel lblMensagem = new JLabel("Nome de usuário atualizado com sucesso");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblMensagem.setBounds(106, 55, 290, 28);
        contentPane.add(lblMensagem);

        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(PerfilEditadoNome.class.getResource("/imgs/JFrameCorreto.png")));
        lblIcone.setBounds(23, 11, 73, 70);
        contentPane.add(lblIcone);

        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnOK.setBackground(new Color(34, 139, 34));
        btnOK.setBounds(160, 85, 53, 28);
        contentPane.add(btnOK);
    }
    
    public static void mostrar() {
        PerfilEditadoNome frame = new PerfilEditadoNome();
        frame.setVisible(true);
    }
}
