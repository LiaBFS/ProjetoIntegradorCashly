package telas;

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
        new TelaLogin().setVisible(true); // Abre a tela de login
    }

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

    public TelaApresentacao() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Faz abrir em tela cheia
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza
        // setUndecorated(true); // Opcional: sem bordas e barra de título
        // setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize()); // Opcional: força resolução exata

        setBounds(100, 100, 1280, 800); // fallback caso tela cheia não funcione

        contentPane = new JPanel();
        contentPane.setBackground(new Color(216, 178, 184));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[376px,grow][50,grow][grow][376px,grow][376px,grow]", "[grow][48px][404px,grow,fill][48px][235px,grow]"));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(216, 178, 184));
        contentPane.add(panel, "cell 0 0 5 1,grow");
        panel.setLayout(new MigLayout("", "[grow 50][][][][][][][grow][][][][grow][][][][][][][][][][grow 50]", "[]"));

        JLabel lblLogo = new JLabel("");
        panel.add(lblLogo, "cell 1 0,alignx left");
        lblLogo.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/LogoCashly.png")));

        JButton btnInicio = new JButton("");
        panel.add(btnInicio, "cell 14 0");
        btnInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnInicio.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnInicio.png")));
        btnInicio.setBorderPainted(false);
        btnInicio.setContentAreaFilled(false);
        btnInicio.setFocusPainted(false);
        btnInicio.setOpaque(false);

        JButton btnCadastrar = new JButton("");
        panel.add(btnCadastrar, "cell 17 0,alignx right,growy");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });
        btnCadastrar.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnCadastro.png")));
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setContentAreaFilled(false);
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setOpaque(false);

        JButton btnLogin = new JButton("");
        panel.add(btnLogin, "cell 20 0,alignx right");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaLogin();
            }
        });
        btnLogin.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnLogin.png")));
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setFocusPainted(false);
        btnLogin.setOpaque(false);

        ImageIcon RecebaAvisos = new ImageIcon(
                TelaApresentacao.class.getResource("/imgs/RecebaAvisos.png"));
        ImageIcon iconOriginal = new ImageIcon(
                TelaApresentacao.class.getResource("/imgs/RepresentacoesGraficas.png"));
        ImageIcon FacaProjetos = new ImageIcon(
                TelaApresentacao.class.getResource("/imgs/FacaProjetos.png"));

        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });

        ImageIcon iconBemVindo = new ImageIcon(
                TelaApresentacao.class.getResource("/imgs/SejaBemVindo.png"));
        btnNewButton.setIcon(iconBemVindo);
        contentPane.add(btnNewButton, "cell 0 2 5 1,grow");
        btnNewButton.setBorderPainted(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setOpaque(false);
        btnNewButton.setMinimumSize(new Dimension(30, 30));
        btnNewButton.setPreferredSize(new Dimension(1000, 1000));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(216, 178, 184));
        contentPane.add(panel_1, "cell 0 4 5 1,grow");
        panel_1.setLayout(new MigLayout("", "[150px][grow][][grow][][grow][150px]", "[]"));

        JButton btnFacaProjetos = new JButton("");
        btnFacaProjetos.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/FacaProjetos.png")));
        panel_1.add(btnFacaProjetos, "cell 1 0,grow");
        btnFacaProjetos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });
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

        JButton btnRecebaAvisos = new JButton("");
        panel_1.add(btnRecebaAvisos, "cell 3 0,grow");
        btnRecebaAvisos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });
        btnRecebaAvisos.setIcon(RecebaAvisos);
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
                    double proporcaoOriginal = (double) RecebaAvisos.getIconWidth() / RecebaAvisos.getIconHeight();
                    int novaLargura = largura;
                    int novaAltura = (int) (largura / proporcaoOriginal);
                    if (novaAltura > altura) {
                        novaAltura = altura;
                        novaLargura = (int) (altura * proporcaoOriginal);
                    }
                    Image img = RecebaAvisos.getImage().getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
                    btnRecebaAvisos.setIcon(new ImageIcon(img));
                }
            }
        });

        JButton btnGrafica = new JButton("");
        panel_1.add(btnGrafica, "cell 5 0,grow");
        btnGrafica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });
        btnGrafica.setIcon(iconOriginal);
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

        btnNewButton.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int largura = btnNewButton.getWidth();
                int altura = btnNewButton.getHeight();
                if (largura > 0 && altura > 0) {
                    double proporcaoOriginal = (double) iconBemVindo.getIconWidth() / iconBemVindo.getIconHeight();
                    int novaLargura = largura;
                    int novaAltura = (int) (largura / proporcaoOriginal);
                    if (novaAltura > altura) {
                        novaAltura = altura;
                        novaLargura = (int) (altura * proporcaoOriginal);
                    }
                    Image img = iconBemVindo.getImage().getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
                    btnNewButton.setIcon(new ImageIcon(img));
                }
            }
        });
    }
}