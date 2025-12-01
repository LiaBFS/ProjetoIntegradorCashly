package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ValorInvalidoLancamento extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public ValorInvalidoLancamento(Window owner) {
        super(owner);
        setTitle("Valor Inválido");
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

        JLabel lblTitulo = new JLabel("Valor Inválido");
        lblTitulo.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setBounds(110, 26, 330, 28);
        contentPane.add(lblTitulo);
        
        JLabel lblMensagem = new JLabel("Digite um valor numérico válido");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblMensagem.setBounds(110, 51, 330, 28);
        contentPane.add(lblMensagem);

        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(ValorInvalidoLancamento.class.getResource("/imgs/EmailInvalido.png")));
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
    
    public static void mostrar(Window owner) {
        ValorInvalidoLancamento dialog = new ValorInvalidoLancamento(owner);
        dialog.setVisible(true);
    }
}