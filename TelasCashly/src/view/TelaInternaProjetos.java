package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInternaProjetos extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaInternaProjetos() {
		
		
		
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[grow]", "[grow][grow][grow][grow][grow]"));
		
		
		
		JPanelComBackground panel_4 = new JPanelComBackground("/imgs/FundoBtn.png");
		add(panel_4, "cell 0 0,grow");
		panel_4.setLayout(new MigLayout("", "[114][241,grow][241,grow][241][241][241][241][241][241][241][114]", "[grow 25][][grow 10][][][][][grow 25]"));
		
		JButton btnNomeProjeto1 = new JButton("Nome do Projeto Criado");
		btnNomeProjeto1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnNomeProjeto1, "cell 3 1");
		btnNomeProjeto1.setOpaque(false);
		btnNomeProjeto1.setForeground(new Color(255, 245, 234));
		btnNomeProjeto1.setFont(new Font("Carlito", Font.BOLD, 29));
		btnNomeProjeto1.setFocusPainted(false);
		btnNomeProjeto1.setContentAreaFilled(false);
		btnNomeProjeto1.setBorderPainted(false);
		
		JButton btnData = new JButton("dd/mm/aa");
		panel_4.add(btnData, "cell 7 1");
		btnData.setOpaque(false);
		btnData.setForeground(new Color(153, 131, 116));
		btnData.setFont(new Font("Carlito", Font.PLAIN, 19));
		btnData.setFocusPainted(false);
		btnData.setContentAreaFilled(false);
		btnData.setBorderPainted(false);
		
		JButton btnDescrição = new JButton("Descrição");
		btnDescrição.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnDescrição, "cell 3 3");
		btnDescrição.setOpaque(false);
		btnDescrição.setForeground(new Color(255, 245, 234));
		btnDescrição.setFont(new Font("Carlito", Font.PLAIN, 14));
		btnDescrição.setFocusPainted(false);
		btnDescrição.setContentAreaFilled(false);
		btnDescrição.setBorderPainted(false);
		
		JPanelComBackground panel_3 = new JPanelComBackground("/imgs/FundoBtn.png");
		add(panel_3, "cell 0 1,grow");
		panel_3.setLayout(new MigLayout("", "[124][241,grow][241,grow][241][241][241][241][241][241][241][124]", "[grow 25][][grow 10][][][][][grow 25]"));
		
		JButton btnNomeProjeto2 = new JButton("Nome do Projeto Criado");
		btnNomeProjeto2.setOpaque(false);
		btnNomeProjeto2.setForeground(new Color(255, 245, 234));
		btnNomeProjeto2.setFont(new Font("Carlito", Font.BOLD, 29));
		btnNomeProjeto2.setFocusPainted(false);
		btnNomeProjeto2.setContentAreaFilled(false);
		btnNomeProjeto2.setBorderPainted(false);
		panel_3.add(btnNomeProjeto2, "flowy,cell 2 0,alignx left,aligny top");
		
		JButton btnData_1 = new JButton("dd/mm/aa");
		btnData_1.setOpaque(false);
		btnData_1.setForeground(new Color(153, 131, 116));
		btnData_1.setFont(new Font("Carlito", Font.PLAIN, 19));
		btnData_1.setFocusPainted(false);
		btnData_1.setContentAreaFilled(false);
		btnData_1.setBorderPainted(false);
		panel_3.add(btnData_1, "cell 7 0,alignx left,aligny center");
		
		JButton btnDescrição_1 = new JButton("Descrição");
		btnDescrição_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDescrição_1.setOpaque(false);
		btnDescrição_1.setForeground(new Color(255, 245, 234));
		btnDescrição_1.setFont(new Font("Carlito", Font.PLAIN, 14));
		btnDescrição_1.setFocusPainted(false);
		btnDescrição_1.setContentAreaFilled(false);
		btnDescrição_1.setBorderPainted(false);
		panel_3.add(btnDescrição_1, "cell 2 1,alignx left,aligny top");
		
		JPanelComBackground panel_2 = new JPanelComBackground("/imgs/FundoBtn.png");
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[114][241,grow][241,grow][241][241][241][241][241][241][241][114]", "[44px][26px]"));
		
		JButton btnNomeProjeto3 = new JButton("Nome do Projeto Criado");
		btnNomeProjeto3.setOpaque(false);
		btnNomeProjeto3.setForeground(new Color(255, 245, 234));
		btnNomeProjeto3.setFont(new Font("Carlito", Font.BOLD, 29));
		btnNomeProjeto3.setFocusPainted(false);
		btnNomeProjeto3.setContentAreaFilled(false);
		btnNomeProjeto3.setBorderPainted(false);
		panel_2.add(btnNomeProjeto3, "cell 0 0,alignx left,aligny top");
		
		JButton btnData_2 = new JButton("dd/mm/aa");
		btnData_2.setOpaque(false);
		btnData_2.setForeground(new Color(153, 131, 116));
		btnData_2.setFont(new Font("Carlito", Font.PLAIN, 19));
		btnData_2.setFocusPainted(false);
		btnData_2.setContentAreaFilled(false);
		btnData_2.setBorderPainted(false);
		panel_2.add(btnData_2, "cell 1 0,alignx left,aligny center");
		
		JButton btnDescrição_2 = new JButton("Descrição");
		btnDescrição_2.setOpaque(false);
		btnDescrição_2.setForeground(new Color(255, 245, 234));
		btnDescrição_2.setFont(new Font("Carlito", Font.PLAIN, 14));
		btnDescrição_2.setFocusPainted(false);
		btnDescrição_2.setContentAreaFilled(false);
		btnDescrição_2.setBorderPainted(false);
		panel_2.add(btnDescrição_2, "cell 0 1,alignx left,aligny top");
		
		JPanelComBackground panel_1 = new JPanelComBackground("/imgs/FundoBtn.png");
		add(panel_1, "cell 0 3,grow");
		panel_1.setLayout(new MigLayout("", "[326px][114px]", "[44px][26px]"));
		
		JButton btnNomeProjeto4 = new JButton("Nome do Projeto Criado");
		btnNomeProjeto4.setOpaque(false);
		btnNomeProjeto4.setForeground(new Color(255, 245, 234));
		btnNomeProjeto4.setFont(new Font("Carlito", Font.BOLD, 29));
		btnNomeProjeto4.setFocusPainted(false);
		btnNomeProjeto4.setContentAreaFilled(false);
		btnNomeProjeto4.setBorderPainted(false);
		panel_1.add(btnNomeProjeto4, "cell 0 0,alignx left,aligny top");
		
		JButton btnData_3 = new JButton("dd/mm/aa");
		btnData_3.setOpaque(false);
		btnData_3.setForeground(new Color(153, 131, 116));
		btnData_3.setFont(new Font("Carlito", Font.PLAIN, 19));
		btnData_3.setFocusPainted(false);
		btnData_3.setContentAreaFilled(false);
		btnData_3.setBorderPainted(false);
		panel_1.add(btnData_3, "cell 1 0,alignx left,aligny center");
		
		JButton btnDescrição_3 = new JButton("Descrição");
		btnDescrição_3.setOpaque(false);
		btnDescrição_3.setForeground(new Color(255, 245, 234));
		btnDescrição_3.setFont(new Font("Carlito", Font.PLAIN, 14));
		btnDescrição_3.setFocusPainted(false);
		btnDescrição_3.setContentAreaFilled(false);
		btnDescrição_3.setBorderPainted(false);
		panel_1.add(btnDescrição_3, "cell 0 1,alignx left,aligny top");
		
		JPanelComBackground panel = new JPanelComBackground("/imgs/FundoBtn.png");
		add(panel, "cell 0 4,grow");
		panel.setLayout(new MigLayout("", "[326px][114px]", "[44px][26px]"));
		
		JButton btnNomeProjeto5 = new JButton("Nome do Projeto Criado");
		btnNomeProjeto5.setOpaque(false);
		btnNomeProjeto5.setForeground(new Color(255, 245, 234));
		btnNomeProjeto5.setFont(new Font("Carlito", Font.BOLD, 29));
		btnNomeProjeto5.setFocusPainted(false);
		btnNomeProjeto5.setContentAreaFilled(false);
		btnNomeProjeto5.setBorderPainted(false);
		panel.add(btnNomeProjeto5, "cell 0 0,alignx left,aligny top");
		
		JButton btnData_4 = new JButton("dd/mm/aa");
		btnData_4.setOpaque(false);
		btnData_4.setForeground(new Color(153, 131, 116));
		btnData_4.setFont(new Font("Carlito", Font.PLAIN, 19));
		btnData_4.setFocusPainted(false);
		btnData_4.setContentAreaFilled(false);
		btnData_4.setBorderPainted(false);
		panel.add(btnData_4, "cell 1 0,alignx left,aligny center");
		
		JButton btnDescrição_4 = new JButton("Descrição");
		btnDescrição_4.setOpaque(false);
		btnDescrição_4.setForeground(new Color(255, 245, 234));
		btnDescrição_4.setFont(new Font("Carlito", Font.PLAIN, 14));
		btnDescrição_4.setFocusPainted(false);
		btnDescrição_4.setContentAreaFilled(false);
		btnDescrição_4.setBorderPainted(false);
		panel.add(btnDescrição_4, "cell 0 1,alignx left,aligny top");

	}

}
