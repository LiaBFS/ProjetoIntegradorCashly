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

public class UsuarioCadastrado extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public UsuarioCadastrado(Window owner) {
        super(owner);
        setTitle("Cadastro Realizado");
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

        JLabel lblTitulo = new JLabel("Cadastro Realizado!");
        lblTitulo.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setBounds(104, 28, 260, 28);
        contentPane.add(lblTitulo);
        
        JLabel lblMensagem = new JLabel("Usuário cadastrado com sucesso");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblMensagem.setBounds(104, 53, 260, 28);
        contentPane.add(lblMensagem);

        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(UsuarioCadastrado.class.getResource("/imgs/JFrameCorreto.png")));
        lblIcone.setBounds(23, 11, 71, 70);
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
        UsuarioCadastrado dialog = new UsuarioCadastrado(null);
        dialog.setVisible(true);
    }
    
    public static void mostrar(Window owner) {
        UsuarioCadastrado dialog = new UsuarioCadastrado(owner);
        dialog.setVisible(true);
    }
}