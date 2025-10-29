package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import model.Projeto;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class TelaInternaProjetos extends JPanel {

	private static final long serialVersionUID = 1L;
	private int linha = 0;
	private JScrollPane scroll_pane;
	private JPanel panel_content;
	private JButton btnNomeProjeto1;
	private JButton btnData;
	private AbstractButton btnDescrição;
	

	/**
	 * Create the panel.
	 */
	public TelaInternaProjetos() {
		
		
		
		setBackground(new Color(216, 178, 184));
		//setLayout(new MigLayout("", "[1390px]", "[175px][175px][175px][175px][175px]"));
		setLayout(new BorderLayout());
		
		scroll_pane = new JScrollPane();
		scroll_pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel_content = new JPanel();
		panel_content.setBackground(new Color(216, 178, 184));

		panel_content.setLayout(new MigLayout("", "[1390px]", "[175px][175px][175px][175px][175px]"));
		scroll_pane.setViewportView(panel_content);

		
		
		add(scroll_pane, BorderLayout.CENTER);
	}
	
	
		
	public JPanel adicionarPainelProjeto(Projeto p) {
		JPanelComBackground panel_4 = new JPanelComBackground("/imgs/FundoBtn.png");
		
		panel_4.setLayout(new MigLayout("", "[266][241,grow][241,grow][][241][][][][][][][241][241][][241][241][241][241][266]", "[grow 25][][][][][][][][grow 10][][][][][][grow 25]"));
		
		btnNomeProjeto1 = new JButton(p.getNome());
//		btnNomeProjeto1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		panel_4.add(btnNomeProjeto1, "cell 4 1");
		btnNomeProjeto1.setOpaque(false);
		btnNomeProjeto1.setForeground(new Color(255, 245, 234));
		btnNomeProjeto1.setFont(new Font("Carlito", Font.BOLD, 35));
		btnNomeProjeto1.setFocusPainted(false);
		btnNomeProjeto1.setContentAreaFilled(false);
		btnNomeProjeto1.setBorderPainted(false);
		
		btnData = new JButton(p.getDataCriacao().toString());
		panel_4.add(btnData, "cell 15 1");
		btnData.setOpaque(false);
		btnData.setForeground(new Color(153, 131, 116));
		btnData.setFont(new Font("Carlito", Font.PLAIN, 25));
		btnData.setFocusPainted(false);
		btnData.setContentAreaFilled(false);
		btnData.setBorderPainted(false);
		
		btnDescrição = new JButton(p.getDescricao());
//		btnDescrição.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		panel_4.add(btnDescrição, "cell 4 2");
		btnDescrição.setOpaque(false);
		btnDescrição.setForeground(new Color(255, 245, 234));
		btnDescrição.setFont(new Font("Carlito", Font.PLAIN, 25));
		btnDescrição.setFocusPainted(false);
		btnDescrição.setContentAreaFilled(false);
		btnDescrição.setBorderPainted(false);
		

		
		
		panel_content.add(panel_4, "cell 0 "+linha+",grow");
		linha++;
		return panel_4;
	}
		
	
}



