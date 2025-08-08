package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaApresentacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaApresentacao frame = new TelaApresentacao();
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
	public TelaApresentacao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 178, 184));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIlustracaoCentral = new JLabel("");
		lblIlustracaoCentral.setBounds(64, 105, 1140, 393);
		lblIlustracaoCentral.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/SejaBemVindo.png")));
		contentPane.add(lblIlustracaoCentral);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/LogoCashly.png")));
		lblLogo.setBounds(64, 50, 365, 32);
		contentPane.add(lblLogo);
		
		JButton btnInicio = new JButton("");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInicio.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnInicio.png")));
		btnInicio.setBounds(756, 48, 113, 32);
		contentPane.add(btnInicio);
		
		btnInicio.setBorderPainted(false);   // remove a borda visível
		btnInicio.setContentAreaFilled(false); // remove o fundo
		btnInicio.setFocusPainted(false);    // remove o destaque quando focado
		btnInicio.setOpaque(false);
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnCadastro.png")));
		btnCadastrar.setBounds(921, 53, 132, 24);
		contentPane.add(btnCadastrar);
		
		btnCadastrar.setBorderPainted(false);   // remove a borda visível
		btnCadastrar.setContentAreaFilled(false); // remove o fundo
		btnCadastrar.setFocusPainted(false);    // remove o destaque quando focado
		btnCadastrar.setOpaque(false);
		
		JButton btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnLogin.png")));
		btnLogin.setBounds(1082, 53, 89, 23);
		contentPane.add(btnLogin);
		
		btnLogin.setBorderPainted(false);   // remove a borda visível
		btnLogin.setContentAreaFilled(false); // remove o fundo
		btnLogin.setFocusPainted(false);    // remove o destaque quando focado
		btnLogin.setOpaque(false);
		
		JButton btnFacaProjetos = new JButton("");
		btnFacaProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFacaProjetos.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/FacaProjetos.png")));
		btnFacaProjetos.setBounds(104, 517, 321, 221);
		contentPane.add(btnFacaProjetos);
		
		btnFacaProjetos.setBorderPainted(false);   // remove a borda visível
		btnFacaProjetos.setContentAreaFilled(false); // remove o fundo
		btnFacaProjetos.setFocusPainted(false);    // remove o destaque quando focado
		btnFacaProjetos.setOpaque(false);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/RecebaAvisos.png")));
		btnNewButton.setBounds(493, 514, 304, 225);
		contentPane.add(btnNewButton);
		
		btnNewButton.setBorderPainted(false);   // remove a borda visível
		btnNewButton.setContentAreaFilled(false); // remove o fundo
		btnNewButton.setFocusPainted(false);    // remove o destaque quando focado
		btnNewButton.setOpaque(false);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/RepresentacoesGraficas.png")));
		btnNewButton_1.setBounds(873, 514, 307, 223);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.setBorderPainted(false);   // remove a borda visível
		btnNewButton_1.setContentAreaFilled(false); // remove o fundo
		btnNewButton_1.setFocusPainted(false);    // remove o destaque quando focado
		btnNewButton_1.setOpaque(false);
	}
}

