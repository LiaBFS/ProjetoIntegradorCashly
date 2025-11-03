package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.MigLayout;

public class TelaInternaLancamentos extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtValorDoLanamento;
    private JTextField txtDataDoLanamento;
    private JComboBox<String> comboBoxCategoria;
    private JButton btnCancelar;
    private JButton btnAdicionar;

    public TelaInternaLancamentos() {
        setTitle("Adicionar Lançamento");
        setBounds(100, 100, 674, 676);
        setLocationRelativeTo(null);
        setModal(true);

        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 245, 234)); 
        contentPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(214, 199, 185), 3, true),
                new EmptyBorder(15, 15, 15, 15)));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new MigLayout("", "[grow][]", "[grow][][grow][][grow][][grow][grow]"));

        // 🔹 Título
        JLabel lblAdicionarLancamento = new JLabel("Adicionar Lançamento", SwingConstants.CENTER);
        lblAdicionarLancamento.setFont(new Font("Dialog", Font.BOLD, 35));
        lblAdicionarLancamento.setForeground(new Color(80, 50, 40));
        contentPanel.add(lblAdicionarLancamento, "cell 0 0 3 1,alignx center,aligny top");

        // 🔹 Painel Valor
        JPanelComBackground panelValor = new JPanelComBackground("/imgs/ValorLançamento.png");
        panelValor.setBackground(new Color(255, 245, 234));
        contentPanel.add(panelValor, "cell 0 2 2 1,grow");
        panelValor.setLayout(new MigLayout("", "[130][grow][95]", "[][][]"));

        txtValorDoLanamento = new JTextField("Valor do Lançamento");
        txtValorDoLanamento.setForeground(new Color(255, 245, 234));
        txtValorDoLanamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtValorDoLanamento.setColumns(10);
        txtValorDoLanamento.setBorder(BorderFactory.createEmptyBorder());
        txtValorDoLanamento.setBackground(new Color(207, 114, 116));
        panelValor.add(txtValorDoLanamento, "cell 1 1,growx");

        // 🔹 Painel Categoria
        JPanelComBackground panelCategoria = new JPanelComBackground("/imgs/CategoriaLançamento.png");
        panelCategoria.setBackground(new Color(255, 245, 234));
        contentPanel.add(panelCategoria, "cell 0 4 2 1,grow");
        panelCategoria.setLayout(new MigLayout("", "[130][grow][95]", "[][][]"));

        comboBoxCategoria = new JComboBox<>();
        comboBoxCategoria.setEditable(true);
        comboBoxCategoria.setBackground(new Color(207, 114, 116));
        comboBoxCategoria.setForeground(new Color(255, 245, 234));
        comboBoxCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBoxCategoria.addItem("Selecione ou digite uma categoria");
        comboBoxCategoria.setSelectedIndex(0);
        panelCategoria.add(comboBoxCategoria, "cell 1 1,growx");

        // 🔹 Painel Data
        JPanelComBackground panelData = new JPanelComBackground("/imgs/DataLançamento.png");
        panelData.setBackground(new Color(255, 245, 234));
        contentPanel.add(panelData, "cell 0 6 2 1,grow");
        panelData.setLayout(new MigLayout("", "[130][grow][95]", "[][][]"));

        txtDataDoLanamento = new JTextField("Data do Lançamento");
        txtDataDoLanamento.setForeground(new Color(255, 245, 234));
        txtDataDoLanamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtDataDoLanamento.setColumns(10);
        txtDataDoLanamento.setBorder(BorderFactory.createEmptyBorder());
        txtDataDoLanamento.setBackground(new Color(207, 114, 116));
        panelData.add(txtDataDoLanamento, "cell 1 1,growx");

        // 🔹 Botões com imagens originais
        btnCancelar = new JButton("");
        btnCancelar.setIcon(new ImageIcon(TelaInternaLancamentos.class.getResource("/imgs/CancelarLançamento.png")));
        estilizarBotao(btnCancelar);
        contentPanel.add(btnCancelar, "cell 0 7,alignx left");

        btnAdicionar = new JButton("");
        btnAdicionar.setIcon(new ImageIcon(TelaInternaLancamentos.class.getResource("/imgs/AdicionarLançamento.png")));
        estilizarBotao(btnAdicionar);
        contentPanel.add(btnAdicionar, "cell 1 7,alignx right");
    }

    private void estilizarBotao(JButton botao) {
        botao.setOpaque(false);
        botao.setFocusPainted(false);
        botao.setContentAreaFilled(false);
        botao.setBorderPainted(false);
    }

    // 🔹 Getters usados pelo Controller
    public JButton getbtnCancelar() {
        return btnCancelar;
    }

    public JButton getbtnAdicionar() {
        return btnAdicionar;
    }

    public JTextField getTxtValorDoLanamento() {
        return txtValorDoLanamento;
    }

    public JTextField getTxtDataDoLanamento() {
        return txtDataDoLanamento;
    }

    public JComboBox<String> getComboBoxCategoria() {
        return comboBoxCategoria;
    }
}
