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

public class ProjetoExcluido extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public ProjetoExcluido(Window owner) {
        super(owner);
        setTitle("Projeto Excluído");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 380, 120);
        setLocationRelativeTo(owner);
        setModal(true);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 234));
        this.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(34, 139, 34), 3));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Projeto Excluído");
        lblTitulo.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setBounds(115, 25, 290, 28);
        contentPane.add(lblTitulo);
        
        JLabel lblMensagem = new JLabel("Projeto excluído com sucesso!");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblMensagem.setBounds(115, 50, 290, 28);
        contentPane.add(lblMensagem);

        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(ProjetoExcluido.class.getResource("/imgs/JFrameCorreto.png")));
        lblIcone.setBounds(23, 11, 82, 67);
        contentPane.add(lblIcone);

        JButton btnOK = new JButton("OK");
        btnOK.setForeground(new Color(255, 245, 234));
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnOK.setBackground(new Color(34, 139, 34));
        btnOK.setBounds(169, 81, 53, 28);
        btnOK.setFocusPainted(false);
        contentPane.add(btnOK);
    }
    
    public static void mostrar() {
        ProjetoExcluido dialog = new ProjetoExcluido(null);
        dialog.setVisible(true);
    }
    
    public static void mostrar(Window owner) {
        ProjetoExcluido dialog = new ProjetoExcluido(owner);
        dialog.setVisible(true);
    }
}