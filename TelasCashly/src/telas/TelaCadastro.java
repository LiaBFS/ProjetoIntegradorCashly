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
import net.miginfocom.swing.MigLayout;

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
		// Faz abrir em tela cheia
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 178, 184));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[100px,grow][35px,grow][100px,grow][35px,grow][100px,grow]", "[grow][75px][70px,grow][75px,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 178, 184));
		contentPane.add(panel, "cell 0 0 5 1,grow");
		panel.setLayout(new MigLayout("", "[grow 50][][][][][][][grow][][][][grow][][][][][][][][][][grow 50]", "[]"));
		
		JLabel lblLogo = new JLabel("");
		panel.add(lblLogo, "cell 1 0,alignx left");
		lblLogo.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/LogoCashly.png")));
		
		JButton btnInicio = new JButton("");
		panel.add(btnInicio, "cell 14 0");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaApresentacao();
			}
		});
		btnInicio.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/BtnInicio2.png")));
		
		btnInicio.setBorderPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setFocusPainted(false);
		btnInicio.setOpaque(false);
		
		JButton btnCadastro = new JButton("");
		panel.add(btnCadastro, "cell 17 0,alignx right,growy");
		btnCadastro.setOpaque(false);
		btnCadastro.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/BtnCadastroSel.png")));
		btnCadastro.setFocusPainted(false);
		btnCadastro.setContentAreaFilled(false);
		btnCadastro.setBorderPainted(false);
		
		JButton btnLogin = new JButton("");
		panel.add(btnLogin, "cell 20 0,alignx right");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaLogin();
			}
		});
		btnLogin.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/BtnLogin.png")));
		
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 178, 184));
		contentPane.add(panel_1, "cell 1 2,alignx right,growy");
		panel_1.setLayout(new MigLayout("", "[100px]", "[grow 50][][grow 50]"));
		
		JButton btnIrProLogin = new JButton("");
		panel_1.add(btnIrProLogin, "cell 0 1");
		btnIrProLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaLogin();
			}
		});
		btnIrProLogin.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/IrProLogin2.png")));
		
		btnIrProLogin.setBorderPainted(false);
		btnIrProLogin.setContentAreaFilled(false);
		btnIrProLogin.setFocusPainted(false);
		btnIrProLogin.setOpaque(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(216, 178, 184));
		contentPane.add(panel_2, "cell 3 2,alignx left,growy");
		panel_2.setLayout(new MigLayout("", "[100px]", "[grow 50][][grow 75][][5px][][5px][][grow 75][][grow 50]"));
		
		JLabel lblCriarConta = new JLabel("");
		panel_2.add(lblCriarConta, "cell 0 1,alignx center,growy");
		lblCriarConta.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/CriarConta.png")));
		
		JLabel lblNome = new JLabel("");
		panel_2.add(lblNome, "cell 0 3");
		lblNome.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/Usuario.png")));
		
		JLabel lblEmail = new JLabel("");
		panel_2.add(lblEmail, "cell 0 5");
		lblEmail.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/Email.png")));
		
		JLabel lblSenha = new JLabel("");
		panel_2.add(lblSenha, "cell 0 7");
		lblSenha.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/Senha.png")));
		
		JButton btnNewButton = new JButton("");
		panel_2.add(btnNewButton, "cell 0 9,alignx center,aligny top");
		btnNewButton.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/ConfirmaCadastro.png")));
		
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		
	}
}