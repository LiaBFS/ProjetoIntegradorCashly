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

	// >>> ADIÇÃO: método para abrir a TelaCadastro <<<
	private void abrirTelaCadastro() {
	    dispose(); // Fecha a tela atual
	    new TelaCadastro().setVisible(true); // Abre a tela de cadastro
	}
	
	private void abrirTelaLogin() {
	    dispose(); // Fecha a tela atual
	    new TelaLogin().setVisible(true); // Abre a tela de cadastro
	}

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
		
		btnInicio.setBorderPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setFocusPainted(false);
		btnInicio.setOpaque(false);
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro(); // <<< ADIÇÃO
			}
		});
		btnCadastrar.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnCadastro.png")));
		btnCadastrar.setBounds(921, 53, 132, 24);
		contentPane.add(btnCadastrar);
		
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setOpaque(false);
		
		JButton btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaLogin(); // <<< ADIÇÃO
			}
		});
		btnLogin.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnLogin.png")));
		btnLogin.setBounds(1082, 53, 89, 23);
		contentPane.add(btnLogin);
		
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setOpaque(false);
		
		JButton btnFacaProjetos = new JButton("");
		btnFacaProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro(); // <<< ADIÇÃO
			}
		});
		btnFacaProjetos.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/FacaProjetos.png")));
		btnFacaProjetos.setBounds(104, 517, 321, 221);
		contentPane.add(btnFacaProjetos);
		
		btnFacaProjetos.setBorderPainted(false);
		btnFacaProjetos.setContentAreaFilled(false);
		btnFacaProjetos.setFocusPainted(false);
		btnFacaProjetos.setOpaque(false);
		
		JButton btnRecebaAvisos = new JButton("");
		btnRecebaAvisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro(); // <<< ADIÇÃO
			}
		});
		btnRecebaAvisos.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/RecebaAvisos.png")));
		btnRecebaAvisos.setBounds(493, 514, 304, 225);
		contentPane.add(btnRecebaAvisos);
		
		btnRecebaAvisos.setBorderPainted(false);
		btnRecebaAvisos.setContentAreaFilled(false);
		btnRecebaAvisos.setFocusPainted(false);
		btnRecebaAvisos.setOpaque(false);
		
		JButton btnGrafica = new JButton("");
		btnGrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro(); // <<< ADIÇÃO
			}
		});
		btnGrafica.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/RepresentacoesGraficas.png")));
		btnGrafica.setBounds(873, 514, 307, 223);
		contentPane.add(btnGrafica);
		
		btnGrafica.setBorderPainted(false);
		btnGrafica.setContentAreaFilled(false);
		btnGrafica.setFocusPainted(false);
		btnGrafica.setOpaque(false);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro();
			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/SejaBemVindo.png")));
		btnNewButton.setBounds(64, 105, 1144, 389);
		contentPane.add(btnNewButton);
		
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
	}
}