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

public class PerfilEditadoNome extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public PerfilEditadoNome(Window owner) {
        super(owner);
        setTitle("Nome Atualizado");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 380, 120);
        setLocationRelativeTo(owner);
        setModal(true);
        
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
        btnOK.setForeground(new Color(255, 245, 234));
        btnOK.addActionListener(e -> dispose());
        btnOK.setBackground(new Color(34, 139, 34));
        btnOK.setBounds(163, 81, 53, 28);
        btnOK.setFocusPainted(false);
        contentPane.add(btnOK);
    }
    
    public static void mostrar() {
        PerfilEditadoNome dialog = new PerfilEditadoNome(null);
        dialog.setVisible(true);
    }
    
    public static void mostrar(Window owner) {
        PerfilEditadoNome dialog = new PerfilEditadoNome(owner);
        dialog.setVisible(true);
    }
}