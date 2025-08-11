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

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private void abrirTelaCadastro() {
	    dispose(); // Fecha a tela atual
	    new TelaCadastro().setVisible(true); // Abre a tela de cadastro
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
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setBackground(new Color(216, 178, 184));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 178, 184));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/LogoCashly.png")));
		lblLogo.setBounds(64, 50, 365, 32);
		contentPane.add(lblLogo);
		
		JButton btnIrCadastro = new JButton("");
		btnIrCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro();
			}
		});
		btnIrCadastro.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/btnIrCadastro.png")));
		btnIrCadastro.setBounds(222, 437, 242, 68);
		contentPane.add(btnIrCadastro);
		
		btnIrCadastro.setBorderPainted(false);
		btnIrCadastro.setContentAreaFilled(false);
		btnIrCadastro.setFocusPainted(false);
		btnIrCadastro.setOpaque(false);
		
		JLabel lblAindaNCriouConta = new JLabel("");
		lblAindaNCriouConta.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/AindaNaoCriouConta.png")));
		lblAindaNCriouConta.setBounds(96, 140, 596, 557);
		contentPane.add(lblAindaNCriouConta);
		
		JButton btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/Login2.png")));
		btnLogin.setBounds(1082, 46, 122, 40);
		contentPane.add(btnLogin);
		
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setOpaque(false);
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro();
			}
		});
		btnCadastrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/BtnCadastro.png")));
		btnCadastrar.setBounds(921, 54, 129, 23);
		contentPane.add(btnCadastrar);
		
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setOpaque(false);
		
		JButton btnInicio = new JButton("");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				abrirTelaApresentacao();
			}
		});
		btnInicio.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/BtnInicio2.png")));
		btnInicio.setBounds(784, 54, 89, 23);
		contentPane.add(btnInicio);
		
		btnInicio.setBorderPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setFocusPainted(false);
		btnInicio.setOpaque(false);
		
		JLabel lblFazerLogin = new JLabel("");
		lblFazerLogin.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/FazerLogin.png")));
		lblFazerLogin.setBounds(770, 198, 315, 53);
		contentPane.add(lblFazerLogin);
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/Email.png")));
		lblEmail.setBounds(733, 275, 408, 68);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("");
		lblSenha.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/Senha.png")));
		lblSenha.setBounds(733, 368, 408, 68);
		contentPane.add(lblSenha);
		
		JButton btnIniciarSessao = new JButton("");
		btnIniciarSessao.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/btnIniciarSessao.png")));
		btnIniciarSessao.setBounds(776, 473, 317, 69);
		contentPane.add(btnIniciarSessao);
		
		btnIniciarSessao.setBorderPainted(false);
		btnIniciarSessao.setContentAreaFilled(false);
		btnIniciarSessao.setFocusPainted(false);
		btnIniciarSessao.setOpaque(false);
		
		
	}
}