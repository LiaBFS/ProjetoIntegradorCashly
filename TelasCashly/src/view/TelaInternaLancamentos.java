package view;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.MigLayout;

public class TelaInternaLancamentos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			TelaInternaLancamentos dialog = new TelaInternaLancamentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TelaInternaLancamentos() {
		setTitle("Adicionar Lançamento");
		setBounds(100, 100, 674, 676);
		setLocationRelativeTo(null);
		setModal(true);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 245, 234)); // fundo suave
		contentPanel.setBorder(new CompoundBorder(
				new LineBorder(new Color(214, 199, 185), 3, true), // borda arredondada
				new EmptyBorder(15, 15, 15, 15)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow][]", "[grow][][grow][][grow][][grow][grow]"));

		// 🔹 Título
		JLabel lblAdicionarLancamento = new JLabel("Adicionar Lançamento", SwingConstants.CENTER);
		lblAdicionarLancamento.setFont(new Font("Dialog", Font.BOLD, 35));
		lblAdicionarLancamento.setForeground(new Color(80, 50, 40));
		contentPanel.add(lblAdicionarLancamento, "cell 0 0 3 1,alignx center,aligny top");
		
		JPanelComBackground panel_2 = new JPanelComBackground("/imgs/NomeLançamento.png");
		panel_2.setBackground(new Color(255, 245, 234));
		contentPanel.add(panel_2, "cell 0 2 2 1,grow");
		panel_2.setLayout(new MigLayout("", "[]", "[10px,grow]"));
		
		JPanelComBackground panel_3 = new JPanelComBackground("/imgs/CategoriaLançamento.png");
		panel_3.setBackground(new Color(255, 245, 234));
		contentPanel.add(panel_3, "cell 0 4 2 1,grow");
		panel_3.setLayout(new MigLayout("", "[]", "[10px,grow]"));
		
		JPanelComBackground panel_4 = new JPanelComBackground("/imgs/DataLançamento.png");
		panel_4.setBackground(new Color(255, 245, 234));
		contentPanel.add(panel_4, "cell 0 6 2 1,grow");
		panel_4.setLayout(new MigLayout("", "[146][146]", "[10px,grow]"));
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(TelaInternaLancamentos.class.getResource("/imgs/CancelarLançamento.png")));
		contentPanel.add(btnCancelar, "flowx,cell 1 7");
		btnCancelar.setOpaque(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.setIcon(new ImageIcon(TelaInternaLancamentos.class.getResource("/imgs/AdicionarLançamento.png")));
		contentPanel.add(btnAdicionar, "cell 1 7");
		btnAdicionar.setOpaque(false);
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
	}

	public AbstractButton getbtnCancelar() {
		return null;
	}

	public AbstractButton getbtnAdicionar() {
		return null;
	}
}


