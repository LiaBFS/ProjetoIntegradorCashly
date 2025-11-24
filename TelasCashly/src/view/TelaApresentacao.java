package view;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.Toolkit;

public class TelaApresentacao extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	private JButton btnCadastrar;
	private JButton btnLogin;
	private JButton btnFacaProjetos;
	private JButton btnRecebaAvisos;
	private JButton btnGrafica;
	private JButton btnPainelCentral;
    
	




	public TelaApresentacao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaApresentacao.class.getResource("/imgs/CashlyIcon.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 700));
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 1280, 800);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(216, 178, 184));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[376px,grow][50,grow][grow][376px,grow][376px,grow]", "[grow][48px][404px,grow,fill][48px][235px,grow][35px]"));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(216, 178, 184));
        contentPane.add(panel, "cell 0 0 5 1,grow");
        panel.setLayout(new MigLayout("", "[grow 50][][][][][][][grow][][][][grow][][][][][][][][][][grow 50]", "[58]"));

        JLabel lblLogo = new JLabel("");
        panel.add(lblLogo, "cell 1 0,growx,aligny center");
        lblLogo.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/LogoCashly.png")));

        ImageIcon LogoCashly = new ImageIcon(
        	    TelaApresentacao.class.getResource("/imgs/LogoCashly.png")
        	);	

        lblLogo.setMinimumSize(new Dimension(10, 5));
        lblLogo.setPreferredSize(new Dimension(500, 500));

        lblLogo.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                int largura = lblLogo.getWidth();
                int altura = lblLogo.getHeight();

                if (largura > 0 && altura > 0) {
                    double proporcaoOriginal = (double) LogoCashly.getIconWidth() / LogoCashly.getIconHeight();
                    int novaLargura = largura;
                    int novaAltura = (int) (largura / proporcaoOriginal);

                    if (novaAltura > altura) {
                        novaAltura = altura;
                        novaLargura = (int) (altura * proporcaoOriginal);
                    }

                    Image img = LogoCashly.getImage().getScaledInstance(
                        novaLargura, novaAltura, Image.SCALE_SMOOTH
                    );
                    lblLogo.setIcon(new ImageIcon(img));
                }
            }
        });
        
        JButton btnInicio = new JButton("");
        panel.add(btnInicio, "cell 14 0,growx,aligny center");
        btnInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnInicio.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnInicio.png")));
        btnInicio.setBorderPainted(false);
        btnInicio.setContentAreaFilled(false);
        btnInicio.setFocusPainted(false);
        btnInicio.setOpaque(false);

        btnCadastrar = new JButton("");
        panel.add(btnCadastrar, "cell 17 0,grow");
       
        btnCadastrar.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnCadastro.png")));
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setContentAreaFilled(false);
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setOpaque(false);

        btnLogin = new JButton("");
        panel.add(btnLogin, "cell 20 0,alignx left,aligny center");
      
        btnLogin.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnLogin.png")));
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setFocusPainted(false);
        btnLogin.setOpaque(false);

        ImageIcon EvoluaObjetivos = new ImageIcon(
                TelaApresentacao.class.getResource("/imgs/EvoluaObjetivos.png"));
        ImageIcon iconOriginal = new ImageIcon(
                TelaApresentacao.class.getResource("/imgs/RepresentacaoGrafica.png"));
        ImageIcon FacaProjetos = new ImageIcon(
                TelaApresentacao.class.getResource("/imgs/FacaProjetos.png"));

        btnPainelCentral = new JButton("");
      
        ImageIcon iconBemVindo = new ImageIcon(
                TelaApresentacao.class.getResource("/imgs/SejaBemVindo.png"));
        btnPainelCentral.setIcon(iconBemVindo);
        contentPane.add(btnPainelCentral, "cell 0 2 5 1,grow");
        btnPainelCentral.setBorderPainted(false);
        btnPainelCentral.setContentAreaFilled(false);
        btnPainelCentral.setFocusPainted(false);
        btnPainelCentral.setOpaque(false);
        btnPainelCentral.setMinimumSize(new Dimension(30, 30));
        btnPainelCentral.setPreferredSize(new Dimension(1000, 1000));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(216, 178, 184));
        contentPane.add(panel_1, "cell 0 4 5 1,grow");
        panel_1.setLayout(new MigLayout("", "[150px][grow][][grow][][grow][150px]", "[]"));

        btnFacaProjetos = new JButton("");
        btnFacaProjetos.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnFacaProjetos.png")));
        panel_1.add(btnFacaProjetos, "cell 1 0,grow");
       
        btnFacaProjetos.setBorderPainted(false);
        btnFacaProjetos.setContentAreaFilled(false);
        btnFacaProjetos.setFocusPainted(false);
        btnFacaProjetos.setOpaque(false);
        btnFacaProjetos.setMinimumSize(new Dimension(30, 30));
        btnFacaProjetos.setPreferredSize(new Dimension(1000, 1000));
        btnFacaProjetos.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int largura = btnFacaProjetos.getWidth();
                int altura = btnFacaProjetos.getHeight();
                if (largura > 0 && altura > 0) {
                    double proporcaoOriginal = (double) FacaProjetos.getIconWidth() / FacaProjetos.getIconHeight();
                    int novaLargura = largura;
                    int novaAltura = (int) (largura / proporcaoOriginal);
                    if (novaAltura > altura) {
                        novaAltura = altura;
                        novaLargura = (int) (altura * proporcaoOriginal);
                    }
                    Image img = FacaProjetos.getImage().getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
                    btnFacaProjetos.setIcon(new ImageIcon(img));
                }
            }
        });

        btnRecebaAvisos = new JButton("");
        panel_1.add(btnRecebaAvisos, "cell 3 0,grow");
       
        btnRecebaAvisos.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/EvoluaObjetivos.png")));
        btnRecebaAvisos.setBorderPainted(false);
        btnRecebaAvisos.setContentAreaFilled(false);
        btnRecebaAvisos.setFocusPainted(false);
        btnRecebaAvisos.setOpaque(false);
        btnRecebaAvisos.setMinimumSize(new Dimension(30, 30));
        btnRecebaAvisos.setPreferredSize(new Dimension(1000, 1000));
        btnRecebaAvisos.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int largura = btnRecebaAvisos.getWidth();
                int altura = btnRecebaAvisos.getHeight();
                if (largura > 0 && altura > 0) {
                    double proporcaoOriginal = (double) EvoluaObjetivos.getIconWidth() / EvoluaObjetivos.getIconHeight();
                    int novaLargura = largura;
                    int novaAltura = (int) (largura / proporcaoOriginal);
                    if (novaAltura > altura) {
                        novaAltura = altura;
                        novaLargura = (int) (altura * proporcaoOriginal);
                    }
                    Image img = EvoluaObjetivos.getImage().getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
                    btnRecebaAvisos.setIcon(new ImageIcon(img));
                }
            }
        });

        btnGrafica = new JButton("");
        
        panel_1.add(btnGrafica, "cell 5 0,grow");
       
        btnGrafica.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/RepresentacaoGrafica.png")));
        btnGrafica.setMinimumSize(new Dimension(30, 30));
        btnGrafica.setPreferredSize(new Dimension(1000, 1000));
        
        btnGrafica.setBorderPainted(false);
        btnGrafica.setContentAreaFilled(false);
        btnGrafica.setFocusPainted(false);
        btnGrafica.setOpaque(false);
        btnGrafica.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int largura = btnGrafica.getWidth();
                int altura = btnGrafica.getHeight();
                if (largura > 0 && altura > 0) {
                    double proporcaoOriginal = (double) iconOriginal.getIconWidth() / iconOriginal.getIconHeight();
                    int novaLargura = largura;
                    int novaAltura = (int) (largura / proporcaoOriginal);
                    if (novaAltura > altura) {
                        novaAltura = altura;
                        novaLargura = (int) (altura * proporcaoOriginal);
                    }
                    Image img = iconOriginal.getImage().getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
                    btnGrafica.setIcon(new ImageIcon(img));
                }
            }
        });

        btnPainelCentral.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int largura = btnPainelCentral.getWidth();
                int altura = btnPainelCentral.getHeight();
                if (largura > 0 && altura > 0) {
                    double proporcaoOriginal = (double) iconBemVindo.getIconWidth() / iconBemVindo.getIconHeight();
                    int novaLargura = largura;
                    int novaAltura = (int) (largura / proporcaoOriginal);
                    if (novaAltura > altura) {
                        novaAltura = altura;
                        novaLargura = (int) (altura * proporcaoOriginal);
                    }
                    Image img = iconBemVindo.getImage().getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
                    btnPainelCentral.setIcon(new ImageIcon(img));
                }
            }
        });
    }






	public JButton getBtnLogin() {
		return btnLogin;
	}





	public JButton getBtnFacaProjetos() {
		return btnFacaProjetos;
	}





	public JButton getBtnRecebaAvisos() {
		return btnRecebaAvisos;
	}





	public JButton getBtnGrafica() {
		return btnGrafica;
	}





	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}



	public JButton getBtnPainelCentral() {
		return btnPainelCentral;
	}



    
    
}