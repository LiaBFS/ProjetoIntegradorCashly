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

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	private void abrirTelaLogin() {
	    dispose(); // Fecha a tela atual
	    new TelaLogin().setVisible(true); // Abre a tela de cadastro
	}
	
	private void abrirTelaApresentacao() {
	    dispose(); // Fecha a tela atual
	    new TelaApresentacao().setVisible(true); // Abre a tela de cadastro
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setBackground(new Color(216, 178, 184));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 178, 184));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastro = new JButton("");
		btnCadastro.setOpaque(false);
		btnCadastro.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/BtnCadastroSel.png")));
		btnCadastro.setFocusPainted(false);
		btnCadastro.setContentAreaFilled(false);
		btnCadastro.setBorderPainted(false);
		btnCadastro.setBounds(908, 48, 161, 35);
		contentPane.add(btnCadastro);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/LogoCashly.png")));
		lblLogo.setBounds(64, 50, 365, 32);
		contentPane.add(lblLogo);
		
		JButton btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaLogin();
			}
		});
		btnLogin.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/BtnLogin.png")));
		btnLogin.setBounds(1082, 53, 89, 23);
		contentPane.add(btnLogin);
		
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setOpaque(false);
		
		JButton btnInicio = new JButton("");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaApresentacao();
			}
		});
		btnInicio.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/BtnInicio2.png")));
		btnInicio.setBounds(784, 54, 89, 23);
		contentPane.add(btnInicio);
		
		btnInicio.setBorderPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setFocusPainted(false);
		btnInicio.setOpaque(false);
		
		JButton btnIrProLogin = new JButton("");
		btnIrProLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaLogin();
			}
		});
		btnIrProLogin.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/IrProLogin.png")));
		btnIrProLogin.setBounds(237, 410, 220, 70);
		contentPane.add(btnIrProLogin);
		
		btnIrProLogin.setBorderPainted(false);
		btnIrProLogin.setContentAreaFilled(false);
		btnIrProLogin.setFocusPainted(false);
		btnIrProLogin.setOpaque(false);
		
		JLabel lblJaTemCadastro = new JLabel("");
		lblJaTemCadastro.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/JaTemCadastro.png")));
		lblJaTemCadastro.setBounds(96, 140, 571, 559);
		contentPane.add(lblJaTemCadastro);
		
		JLabel lblCriarConta = new JLabel("");
		lblCriarConta.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/CriarConta.png")));
		lblCriarConta.setBounds(755, 185, 340, 59);
		contentPane.add(lblCriarConta);
		
		JButton btnConfirmaCadastro = new JButton("");
		btnConfirmaCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmaCadastro.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/ConfirmaCadastro.png")));
		btnConfirmaCadastro.setBounds(802, 539, 274, 65);
		contentPane.add(btnConfirmaCadastro);
		
		btnConfirmaCadastro.setBorderPainted(false);
		btnConfirmaCadastro.setContentAreaFilled(false);
		btnConfirmaCadastro.setFocusPainted(false);
		btnConfirmaCadastro.setOpaque(false);
		
		JLabel lblSenha = new JLabel("");
		lblSenha.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/Senha.png")));
		lblSenha.setBounds(733, 435, 410, 70);
		contentPane.add(lblSenha);
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/Email.png")));
		lblEmail.setBounds(733, 350, 410, 70);
		contentPane.add(lblEmail);
		
		JLabel lblNome = new JLabel("");
		lblNome.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/Usuario.png")));
		lblNome.setBounds(733, 265, 410, 70);
		contentPane.add(lblNome);
		
		
		
	}
}