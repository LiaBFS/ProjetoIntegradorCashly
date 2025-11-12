package view;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.MigLayout;

public class TelaInternaLancamentos extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtValorDoLanamento;
    private JTextField txtDataDoLanamento;
    private JButton btnCancelar;
    private JButton btnAdicionar;
    private String placeholderValorLancamento = "Valor do Lançamento";
    private String placeholderDataLancamento = "Data do Lancamento";

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
        contentPanel.setLayout(new MigLayout("", "[grow][]", "[grow][][grow][][grow][grow]"));


        JLabel lblAdicionarLancamento = new JLabel("Adicionar Lançamento", SwingConstants.CENTER);
        lblAdicionarLancamento.setFont(new Font("Dialog", Font.BOLD, 35));
        lblAdicionarLancamento.setForeground(new Color(80, 50, 40));
        contentPanel.add(lblAdicionarLancamento, "cell 0 0 3 1,alignx center,aligny top");


        JPanelComBackground panelValor = new JPanelComBackground("/imgs/ValorLançamento.png");
        panelValor.setBackground(new Color(255, 245, 234));
        contentPanel.add(panelValor, "cell 0 2 2 1,grow");
        panelValor.setLayout(new MigLayout("", "[130][grow][95]", "[][][]"));

        txtValorDoLanamento = new JTextField();
        txtValorDoLanamento.setForeground(new Color(255, 245, 234));
        txtValorDoLanamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtValorDoLanamento.setText(placeholderValorLancamento);
        txtValorDoLanamento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtValorDoLanamento.getText().equals(placeholderValorLancamento)) {
					txtValorDoLanamento.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtValorDoLanamento.getText().isEmpty()) {
					txtValorDoLanamento.setText(placeholderValorLancamento);
				}
			}
		});
        txtValorDoLanamento.setBackground(new Color(207, 114, 116));
        panelValor.add(txtValorDoLanamento, "cell 1 1,growx,aligny center");
        txtValorDoLanamento.setColumns(10);
        txtValorDoLanamento.setBorder(BorderFactory.createEmptyBorder());


        JPanelComBackground panelData = new JPanelComBackground("/imgs/DataLançamento.png");
        panelData.setBackground(new Color(255, 245, 234));
        contentPanel.add(panelData, "cell 0 4 2 1,grow");
        panelData.setLayout(new MigLayout("", "[130][grow][95]", "[][][]"));

        txtDataDoLanamento = new JTextField();
        txtDataDoLanamento.setForeground(new Color(255, 245, 234));
        txtDataDoLanamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtDataDoLanamento.setText(placeholderDataLancamento);
        
        txtDataDoLanamento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtDataDoLanamento.getText().equals(placeholderDataLancamento)) {
					txtDataDoLanamento.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtDataDoLanamento.getText().isEmpty()) {
					txtDataDoLanamento.setText(placeholderDataLancamento);
				}
			}
		});
        
        
        txtDataDoLanamento.setColumns(10);
        txtDataDoLanamento.setBorder(BorderFactory.createEmptyBorder());
        txtDataDoLanamento.setBackground(new Color(207, 114, 116));
        panelData.add(txtDataDoLanamento, "cell 1 1,growx");

        
        btnCancelar = new JButton("");
        btnCancelar.setIcon(new ImageIcon(TelaInternaLancamentos.class.getResource("/imgs/CancelarLançamento.png")));
        estilizarBotao(btnCancelar);
        contentPanel.add(btnCancelar, "cell 0 5,alignx left");

        btnAdicionar = new JButton("");
        btnAdicionar.setIcon(new ImageIcon(TelaInternaLancamentos.class.getResource("/imgs/AdicionarLançamento.png")));
        estilizarBotao(btnAdicionar);
        contentPanel.add(btnAdicionar, "cell 1 5,alignx right");
    }

    private void estilizarBotao(JButton botao) {
        botao.setOpaque(false);
        botao.setFocusPainted(false);
        botao.setContentAreaFilled(false);
        botao.setBorderPainted(false);
    }

 
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


}
