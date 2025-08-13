package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TelaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicio() {
		setBackground(new Color(216, 178, 184));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 178, 184));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFundoProjetos = new JButton("");
		btnFundoProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFundoProjetos.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/FundoBtn.png")));
		btnFundoProjetos.setBounds(296, 145, 950, 211);
		contentPane.add(btnFundoProjetos);
		
		btnFundoProjetos.setBorderPainted(false);
		btnFundoProjetos.setContentAreaFilled(false);
		btnFundoProjetos.setFocusPainted(false);
		btnFundoProjetos.setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BemVindoDeVolta.png")));
		lblNewLabel.setBounds(296, 360, 958, 390);
		contentPane.add(lblNewLabel);
		
		
	}
}