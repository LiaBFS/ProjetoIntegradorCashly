package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PerfilEditadoEmail extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public PerfilEditadoEmail(Window owner) {
        super(owner);
        setTitle("Email Atualizado");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 350, 120);
        setLocationRelativeTo(owner);
        setModal(true);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 234));
        this.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(34, 139, 34), 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Email Atualizado!");
        lblTitulo.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setBounds(106, 28, 260, 28);
        contentPane.add(lblTitulo);
        
        JLabel lblMensagem = new JLabel("Email atualizado com sucesso");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblMensagem.setBounds(106, 53, 260, 28);
        contentPane.add(lblMensagem);

        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(PerfilEditadoEmail.class.getResource("/imgs/JFrameCorreto.png")));
        lblIcone.setBounds(23, 11, 73, 70);
        contentPane.add(lblIcone);

        JButton btnOK = new JButton("OK");
        btnOK.setForeground(new Color(255, 245, 234));
        btnOK.addActionListener(e -> dispose());
        btnOK.setBackground(new Color(34, 139, 34));
        btnOK.setBounds(148, 81, 53, 28);
        btnOK.setFocusPainted(false);
        contentPane.add(btnOK);
    }
    
    public static void mostrar() {
        PerfilEditadoEmail dialog = new PerfilEditadoEmail(null);
        dialog.setVisible(true);
    }
    
    public static void mostrar(Window owner) {
        PerfilEditadoEmail dialog = new PerfilEditadoEmail(owner);
        dialog.setVisible(true);
    }
}