package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TelaInternaPerfil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaInternaPerfil() {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));
		
		JPanelComBackground panel = new JPanelComBackground("/imgs/FundoPerfil22.png");
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[0][40][500][500,grow][200px][40][0]", "[150px][50px][][40,grow][][][60][][][60][][75px]"));
		
		JPanel panel_1 = new JPanel();
		
		panel.add(panel_1, "cell 2 3 3 7,grow");
		panel_1.setLayout(new MigLayout("", "[][grow][grow][grow]", "[grow][grow][grow][grow][grow][][grow][grow][grow][grow]"));
		
		
		
		panel_1.setOpaque(false);
		
		panel_1.setOpaque(false);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/JPNomePerfil.png")));
		panel_1.add(lblNewLabel_1, "flowx,cell 1 1");
		lblNewLabel_1.setForeground(new Color(72, 53, 40));
		lblNewLabel_1.setFont(new Font("Carlito", Font.BOLD, 20));
		
		ImageIcon JPNomePerfil = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/JPNomePerfil.png")
			);	
		
		lblNewLabel_1.setMinimumSize(new Dimension(10, 5));
		lblNewLabel_1.setPreferredSize(new Dimension(500, 100));
		
		lblNewLabel_1.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = JPNomePerfil.getIconWidth();
		        int altura = JPNomePerfil.getIconHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) JPNomePerfil.getIconWidth() / JPNomePerfil.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = JPNomePerfil.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            lblNewLabel_1.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 1 2 2 1,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		

		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setOpaque(false);
		
		btnNewButton_3.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/Editar.png")));
		panel_1.add(btnNewButton_3, "cell 3 2,alignx right");
		btnNewButton_3.setFont(new Font("Carlito", Font.BOLD, 19));
		btnNewButton_3.setForeground(new Color(255, 245, 234));
		btnNewButton_3.setBackground(new Color(207, 114, 116));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/JPEmailPerfil.png")));
		panel_1.add(lblNewLabel, "cell 1 4");
		lblNewLabel.setForeground(new Color(72, 53, 40));
		lblNewLabel.setFont(new Font("Carlito", Font.BOLD, 20));
		
		textField = new JTextField();
		panel_1.add(textField, "cell 1 5 2 1,growx");
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/Editar.png")));
		panel_1.add(btnNewButton_2, "cell 3 5,alignx right");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setOpaque(false);
		
		btnNewButton_2.setFont(new Font("Carlito", Font.BOLD, 19));
		btnNewButton_2.setForeground(new Color(255, 245, 234));
		btnNewButton_2.setBackground(new Color(207, 114, 116));
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/Sair.png")));
		panel_1.add(btnSair, "cell 1 8");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnSair.setBorderPainted(false);
		btnSair.setContentAreaFilled(false);
		btnSair.setFocusPainted(false);
		btnSair.setOpaque(false);
		btnSair.setFont(new Font("Carlito", Font.BOLD, 19));
		btnSair.setForeground(new Color(255, 245, 234));
		btnSair.setBackground(new Color(207, 114, 116));
		
		JButton btnExcluirPerfil = new JButton("");
		btnExcluirPerfil.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/Excluir.png")));
		panel_1.add(btnExcluirPerfil, "cell 2 8");
		btnExcluirPerfil.setFont(new Font("Carlito", Font.BOLD, 19));
		btnExcluirPerfil.setForeground(new Color(255, 245, 234));
		btnExcluirPerfil.setBackground(new Color(193, 31, 35));
		btnExcluirPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluirPerfil.setBorderPainted(false);
		btnExcluirPerfil.setContentAreaFilled(false);
		btnExcluirPerfil.setFocusPainted(false);
		btnExcluirPerfil.setOpaque(false);
		

	}

}
