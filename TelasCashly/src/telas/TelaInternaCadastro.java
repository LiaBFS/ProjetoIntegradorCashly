package telas;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JButton;

public class TelaInternaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaInternaCadastro() {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[50px,grow][100px,grow][35px,grow][70px][476px,grow][130px,grow]", "[grow][grow][75px,grow][70px,grow][75px,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 178, 184));
		add(panel, "cell 0 0 6 1,grow");
		panel.setLayout(new MigLayout("", "[grow 50][][][][][][][grow][][][][grow][][][][][][][][][][grow 50]", "[70px,fill]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setPreferredSize(new Dimension(500, 500));
		lblLogo.setMinimumSize(new Dimension(10, 5));
		lblLogo.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/LogoCashly.png")));
		panel.add(lblLogo, "cell 1 0,growy");
		
		JButton btnInicio = new JButton("");
		btnInicio.setOpaque(false);
		btnInicio.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/BtnInicio2.png")));
		btnInicio.setFocusPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		panel.add(btnInicio, "cell 14 0");
		
		JButton btnCadastro = new JButton("");
		btnCadastro.setOpaque(false);
		btnCadastro.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/BtnCadastroSel.png")));
		btnCadastro.setFocusPainted(false);
		btnCadastro.setContentAreaFilled(false);
		btnCadastro.setBorderPainted(false);
		panel.add(btnCadastro, "cell 17 0");
		
		JButton btnLogin = new JButton("");
		btnLogin.setOpaque(false);
		btnLogin.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/BtnLogin.png")));
		btnLogin.setFocusPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		panel.add(btnLogin, "cell 20 0");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 178, 184));
		add(panel_1, "cell 2 2 2 2,grow");
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow][][grow]"));
		
		JButton btnIrProLogin = new JButton("");
		btnIrProLogin.setPreferredSize(new Dimension(1000, 1000));
		btnIrProLogin.setOpaque(false);
		btnIrProLogin.setMinimumSize(new Dimension(600, 600));
		btnIrProLogin.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/IrProLogin2.png")));
		btnIrProLogin.setFocusPainted(false);
		btnIrProLogin.setContentAreaFilled(false);
		btnIrProLogin.setBorderPainted(false);
		btnIrProLogin.setBackground(new Color(216, 178, 184));
		panel_1.add(btnIrProLogin, "cell 0 1 1 2,grow");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(216, 178, 184));
		add(panel_2, "cell 4 2 1 2,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow 50][][grow 75][][5px][][5px][][grow 75][][grow 50]"));
		
		JLabel lblCriarConta = new JLabel("");
		lblCriarConta.setPreferredSize(new Dimension(500, 100));
		lblCriarConta.setMinimumSize(new Dimension(200, 100));
		lblCriarConta.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/CriarConta.png")));
		panel_2.add(lblCriarConta, "cell 0 1");
		
		JLabel lblNome = new JLabel("");
		lblNome.setPreferredSize(new Dimension(500, 100));
		lblNome.setMinimumSize(new Dimension(300, 100));
		lblNome.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/Usuario.png")));
		panel_2.add(lblNome, "cell 0 3");
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setPreferredSize(new Dimension(500, 100));
		lblEmail.setMinimumSize(new Dimension(300, 100));
		lblEmail.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/Email.png")));
		panel_2.add(lblEmail, "cell 0 5");
		
		JLabel lblSenha = new JLabel("");
		lblSenha.setPreferredSize(new Dimension(500, 100));
		lblSenha.setMinimumSize(new Dimension(300, 100));
		lblSenha.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/Senha.png")));
		panel_2.add(lblSenha, "cell 0 7");
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.setPreferredSize(new Dimension(500, 100));
		btnCadastrar.setOpaque(false);
		btnCadastrar.setMinimumSize(new Dimension(300, 100));
		btnCadastrar.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/ConfirmaCadastro.png")));
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBorderPainted(false);
		panel_2.add(btnCadastrar, "cell 0 9");

	}

}
