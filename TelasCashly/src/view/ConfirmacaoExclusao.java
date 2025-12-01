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

public class ConfirmacaoExclusao extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int resultado = -1; // -1 = sem resposta, 0 = Cancelar, 1 = Continuar
    
    // Cores personalizadas
    private static final Color COR_FUNDO = new Color(255, 245, 234);
    private static final Color COR_BORDA = new Color(255, 193, 7); // Amarelo
    private static final Color COR_BOTAO = new Color(255, 193, 7); // Amarelo
    private static final Color COR_TEXTO_BOTAO = new Color(255, 255, 255); // Branco
    private static final Color COR_TEXTO = new Color(72, 53, 40);

    public ConfirmacaoExclusao(Window owner, String nomeProjeto) {
        super(owner);
        setTitle("Confirmação de Exclusão");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 420, 140);
        setLocationRelativeTo(owner);
        setModal(true);
        
        contentPane = new JPanel();
        contentPane.setBackground(COR_FUNDO);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(COR_BORDA, 3));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Ícone de aviso
        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon(ConfirmacaoExclusao.class.getResource("/imgs/PERIGO.png")));
        lblIcone.setBounds(0, 25, 120, 101);
        contentPane.add(lblIcone);

        // Mensagem
        JLabel lblMensagem = new JLabel("<html>Você realmente quer excluir o projeto \"" + nomeProjeto + "\"?</html>");
        lblMensagem.setFont(new Font("Carlito", Font.PLAIN, 16));
        lblMensagem.setForeground(COR_TEXTO);
        lblMensagem.setBounds(120, 28, 300, 57);
        contentPane.add(lblMensagem);

        // Botão Continuar
        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setForeground(new Color(72, 53, 40));
        btnContinuar.setBackground(COR_BOTAO);
        btnContinuar.setFont(new Font("Carlito", Font.BOLD, 14));
        btnContinuar.setBounds(130, 82, 110, 30);
        btnContinuar.setFocusPainted(false);
        btnContinuar.addActionListener(e -> {
            resultado = 1;
            dispose();
        });
        contentPane.add(btnContinuar);

        // Botão Cancelar
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(new Color(72, 53, 40));
        btnCancelar.setBackground(new Color(255, 193, 7));
        btnCancelar.setFont(new Font("Carlito", Font.BOLD, 14));
        btnCancelar.setBounds(264, 82, 110, 30);
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(e -> {
            resultado = 0;
            dispose();
        });
        contentPane.add(btnCancelar);
    }
    
    /**
     * Retorna o resultado da escolha do usuário
     * @return 1 se clicou em Continuar, 0 se clicou em Cancelar, -1 se fechou sem escolher
     */
    public int getResultado() {
        return resultado;
    }
    
    /**
     * Mostra o diálogo e retorna true se o usuário confirmou a exclusão
     */
    public static boolean mostrar(Window owner, String nomeProjeto) {
        ConfirmacaoExclusao dialog = new ConfirmacaoExclusao(owner, nomeProjeto);
        dialog.setVisible(true);
        return dialog.getResultado() == 1;
    }
}