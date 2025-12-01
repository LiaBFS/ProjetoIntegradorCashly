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

public class SaldoInvalido extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public SaldoInvalido(Window owner) {
        super(owner);
        setTitle("Saldo Inválido");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 420, 120);
        setLocationRelativeTo(owner);
        setModal(true);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 234));
        this.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(207, 114, 116), 3));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Saldo Inválido");
        lblTitulo.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setBounds(110, 26, 330, 28);
        contentPane.add(lblTitulo);
        
        JLabel lblMensagem = new JLabel("Digite apenas números no campo Saldo");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblMensagem.setBounds(110, 51, 330, 28);
        contentPane.add(lblMensagem);

        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(SaldoInvalido.class.getResource("/imgs/EmailInvalido.png")));
        lblIcone.setBounds(24, 11, 63, 70);
        contentPane.add(lblIcone);

        JButton btnOK = new JButton("OK");
        btnOK.setForeground(new Color(255, 245, 234));
        btnOK.addActionListener(e -> dispose());
        btnOK.setBackground(new Color(207, 114, 116));
        btnOK.setBounds(170, 81, 53, 28);
        btnOK.setFocusPainted(false);
        contentPane.add(btnOK);
    }
    
    public static void mostrar() {
        SaldoInvalido dialog = new SaldoInvalido(null);
        dialog.setVisible(true);
    }
    
    public static void mostrar(Window owner) {
        SaldoInvalido dialog = new SaldoInvalido(owner);
        dialog.setVisible(true);
    }
}