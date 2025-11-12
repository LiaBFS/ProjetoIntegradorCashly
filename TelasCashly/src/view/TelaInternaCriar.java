package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import model.ProjetoDAO;
import model.UsuarioDAO;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaInternaCriar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnCriar;
	private String placeholderNomeProjeto = "Nome do Projeto";
	private String placeholderDescricao = "Descrição do Projeto";
	private String placeholderSaldo = "Saldo Atual Disponível para o Projeto";
	private String placeholderObjetivo = "Objetivo Final";

	/**
	 * Create the panel.
	 */
	public TelaInternaCriar() {

		

		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[grow]", "[][grow][]"));

		JPanelComBackground panel = new JPanelComBackground("/imgs/FundoCriarProjeto2.png");
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[48][grow][48]", "[120px][grow][grow][120px]"));
																										
		btnCriar = new JButton("");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				}
			});
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 1 1 1 2,grow");
		panel_1.setLayout(new MigLayout(", fill", "[]", "[grow][grow][grow][grow]"));
		panel_1.setOpaque(false);
		
		
		JPanelComBackground panel_2 = new JPanelComBackground("/imgs/NomeProjetoPT2.png");
		panel_2.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_2, "cell 0 0 3 1,grow");
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		panel_1.setOpaque(false);
		
		JPanelComBackground panel_3 = new JPanelComBackground("/imgs/DescricaoProjetoPP2.png");
		panel_3.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_3, "cell 0 1 3 1,grow");
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JPanelComBackground panel_4 = new JPanelComBackground("/imgs/SaldoAtualPT2.png");
		panel_4.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_4, "cell 0 2,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JPanelComBackground panel_5 = new JPanelComBackground("/imgs/ObjetivoProjetoPT2.png");
		panel_5.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_5, "cell 2 2,grow");
		panel_5.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JPanelComBackground panel_6 = new JPanelComBackground("/imgs/CategoriaProjetoPP2.png");
		panel_6.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_6, "cell 0 3 3 1,grow");
		panel_6.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		btnCriar.setIcon(new ImageIcon(TelaInternaCriar.class.getResource("/imgs/btnCriar.png")));
		btnCriar.setOpaque(false);
		btnCriar.setFocusPainted(false);
		btnCriar.setContentAreaFilled(false);
		btnCriar.setBorderPainted(false);
		panel.add(btnCriar, "cell 1 3,alignx center,growy");
		

	}
	

	public String getPlaceholderNomeProjeto() {
		return placeholderNomeProjeto;
	}


	public String getPlaceholderDescricao() {
		return placeholderDescricao;
	}


	public String getPlaceholderSaldo() {
		return placeholderSaldo;
	}
	
	public String getPlaceholderObjetivo() {
		return placeholderObjetivo;
	}


	public JTextField getTfNomeProjeto() {
		return tfNomeProjeto;
	}


	public JTextField getTfDescricaoProjeto() {
		return tfDescricaoProjeto;
	}


	public JTextField getTfSaldo() {
		return tfSaldo;
	}


	public JButton getBtnCriar() {
		return btnCriar;
	}


	public JTextField getTfObjetivo() {
		return tfObjetivo;
	}

}
