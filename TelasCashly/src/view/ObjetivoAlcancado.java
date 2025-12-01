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

public class ObjetivoAlcancado extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    // Cores personalizadas para o tema de sucesso/objetivo
    private static final Color COR_FUNDO = new Color(255, 245, 234);
    private static final Color COR_BORDA = new Color(207, 114, 116); // Amarelo/Dourado
    private static final Color COR_BOTAO = new Color(207, 114, 116); // Amarelo/Dourado
    private static final Color COR_TEXTO_BOTAO = new Color(255, 255, 255);

    public ObjetivoAlcancado(Window owner) {
        super(owner);
        setTitle("Parabéns!");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 400, 149);
        setLocationRelativeTo(owner);
        setModal(true);
        
        contentPane = new JPanel();
        contentPane.setBackground(COR_FUNDO);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(COR_BORDA, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Ícone de sucesso
        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(ObjetivoAlcancado.class.getResource("/imgs/JFrameCorreto.png")));
        lblIcone.setBounds(20, 25, 76, 70);
        contentPane.add(lblIcone);

        // Título
        JLabel lblTitulo = new JLabel("Parabéns! Objetivo Alcançado!");
        lblTitulo.setFont(new Font("Carlito", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(72, 53, 40));
        lblTitulo.setBounds(110, 25, 380, 30);
        contentPane.add(lblTitulo);
        
        // Mensagem
        JLabel lblMensagem = new JLabel("Você atingiu o objetivo do seu projeto!");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 15));
        lblMensagem.setForeground(new Color(72, 53, 40));
        lblMensagem.setBounds(110, 55, 380, 25);
        contentPane.add(lblMensagem);
        
        // Mensagem adicional
        JLabel lblMensagemAdicional = new JLabel("Não é possível adicionar mais lançamentos.");
        lblMensagemAdicional.setFont(new Font("Carlito", Font.PLAIN, 14));
        lblMensagemAdicional.setForeground(new Color(100, 80, 70));
        lblMensagemAdicional.setBounds(110, 78, 380, 25);
        contentPane.add(lblMensagemAdicional);

        // Botão OK
        JButton btnOK = new JButton("OK");
        btnOK.setForeground(COR_TEXTO_BOTAO);
        btnOK.setBackground(COR_BOTAO);
        btnOK.setFont(new Font("Carlito", Font.BOLD, 14));
        btnOK.setBounds(175, 110, 53, 28);
        btnOK.setFocusPainted(false);
        btnOK.addActionListener(e -> dispose());
        contentPane.add(btnOK);
    }
    
    /**
     * Mostra o diálogo de objetivo alcançado
     */
    public static void mostrar(Window owner) {
        ObjetivoAlcancado dialog = new ObjetivoAlcancado(owner);
        dialog.setVisible(true);
    }
}