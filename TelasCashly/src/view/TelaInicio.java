package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Dimension;

public class TelaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	boolean menuAberto = true;
	boolean meusProjetosAberto = true;
	private JPanel panelMenu_expanded;
	private JPanel panel_Central;
	private JPanel panelMenuContracted;
	private JPanel panelActual;
	
	private JButton btnMeusProjetos;
	private JButton btnCriarProjetos;
	private JButton btnNotificacoes;
	//private JButton btnColaboradores;
	private JButton btnPerfil;

	private ImageIcon iconMeusProjetos = new ImageIcon(getClass().getResource("/imgs/BtnMeusProjetos.png"));
	private ImageIcon iconMeusProjetosSel = new ImageIcon(getClass().getResource("/imgs/btnMeusProjetosSEL.png"));

	private ImageIcon iconCriarProjetos = new ImageIcon(getClass().getResource("/imgs/BtnCriarProjetos.png"));
	private ImageIcon iconCriarProjetosSel = new ImageIcon(getClass().getResource("/imgs/btnCriarProjetoSEL.png"));

	private ImageIcon iconRelatorio = new ImageIcon(getClass().getResource("/imgs/BtnRelatorio.png"));
	private ImageIcon iconRelatorioSel = new ImageIcon(getClass().getResource("/imgs/btnRelatorioSEL.png"));


	private ImageIcon iconPerfil = new ImageIcon(getClass().getResource("/imgs/BtnPerfil.png"));
	private ImageIcon iconPerfilSel = new ImageIcon(getClass().getResource("/imgs/btnPerfilSEL.png"));
	private JButton btnAbrirMenu;
	private JButton btnHome;
	private JButton btnExit;

	public JButton getBtnHome() {
		return btnHome;
	}

	public void selecionarBotao(JButton botaoSelecionado) {
		
	    // Reseta todos os ícones
	    btnMeusProjetos.setIcon(iconMeusProjetos);
	    btnCriarProjetos.setIcon(iconCriarProjetos);
	    btnNotificacoes.setIcon(iconRelatorio);
	    //btnColaboradores.setIcon(iconColaboradores);
	    btnPerfil.setIcon(iconPerfil);

	    // Ativa o ícone selecionado do botão clicado
	    if (botaoSelecionado == btnMeusProjetos) {
	        botaoSelecionado.setIcon(iconMeusProjetosSel);
	    } else if (botaoSelecionado == btnCriarProjetos) {
	        botaoSelecionado.setIcon(iconCriarProjetosSel);
	    } else if (botaoSelecionado == btnNotificacoes) {
	        botaoSelecionado.setIcon(iconRelatorioSel);
	    } //else if (botaoSelecionado == btnColaboradores) {
	        //botaoSelecionado.setIcon(iconColaboradoresSel);
	     else if (botaoSelecionado == btnPerfil) {
	        botaoSelecionado.setIcon(iconPerfilSel);
	    }
	}

	/**
	 * Create the frame.
	 */
	
	public void atualizarMenuLateral() {
	    panelMenu_expanded.revalidate();
        panelMenu_expanded.repaint();


        panel_Central.revalidate();
        panel_Central.repaint();
	}
	
	
	public void atualizarPainel (JPanel painel) {
		panel_Central.remove(panelActual);
	        panelActual = painel;
        panel_Central.add(panelActual, BorderLayout.CENTER);
     //   this.pack();
	}
	
	
	public TelaInicio() {
		
		
		
		setBackground(new Color(216, 178, 184));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(950, 690)); 

		
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza
        

        
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(180, 98, 100));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(null);
		

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("insets 0", "[958px,grow,fill]", "[70px,fill][630px,grow,fill]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(207, 114, 116));
		contentPane.add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[5px,grow 5][60px][grow 10][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][5px,grow 5]", "[fill]"));
		
		btnAbrirMenu = new JButton("");
		btnAbrirMenu.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnMenu.png")));
		
		
		
		
		
		
		btnAbrirMenu.setBorderPainted(false);
		btnAbrirMenu.setContentAreaFilled(false);
		btnAbrirMenu.setFocusPainted(false);
		btnAbrirMenu.setOpaque(false);
		panel.add(btnAbrirMenu, "cell 1 0,alignx left,aligny bottom");
		
		JLabel lblLogoCashly = new JLabel("");
		lblLogoCashly.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/LogoCashly2.png")));
		panel.add(lblLogoCashly, "cell 3 0,alignx center,growy");
		
		btnHome = new JButton("");
		
		btnHome.setMargin(new Insets(1, 1, 1, 1));
		btnHome.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnHome.png")));
		
		
		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setFocusPainted(false);
		btnHome.setOpaque(false);
		panel.add(btnHome, "cell 32 0");
		
		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnExit.png")));
		panel.add(btnExit, "cell 35 0");
		btnExit.setBorderPainted(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setFocusPainted(false);
		btnExit.setOpaque(false);
		
		
		panel_Central = new JPanel();
		panel_Central.setBackground(new Color(255, 128, 128));
		contentPane.add(panel_Central, "cell 0 1,grow");
		panel_Central.setLayout(new BorderLayout(0, 0));
		
		panelMenu_expanded = new JPanel();
		panelMenu_expanded.setBackground(new Color(255, 245, 234));
		//panel_1.add(panelMenu_expanded, BorderLayout.WEST);
		panelMenu_expanded.setLayout(new MigLayout("", "[244px]", "[2px][grow 2][grow 2][grow 2][grow 2][][][][][grow][][][][][][]"));
		panel_Central.add(panelMenu_expanded, BorderLayout.WEST);
		
		

		btnMeusProjetos = new JButton("");
		btnMeusProjetos.setMargin(new Insets(2, 2, 2, 2));

		btnMeusProjetos.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnMeusProjetos.png")));
		panelMenu_expanded.add(btnMeusProjetos, "cell 0 1,growx,aligny center");
		
		btnMeusProjetos.setBorderPainted(false);
		btnMeusProjetos.setContentAreaFilled(false);
		btnMeusProjetos.setFocusPainted(false);
		btnMeusProjetos.setOpaque(false);
		
		btnMeusProjetos.setPreferredSize(new Dimension(70, 70));
		btnMeusProjetos.setMinimumSize(new Dimension(30, 30));
		
		
		
		
		btnCriarProjetos = new JButton("");
		btnCriarProjetos.setMargin(new Insets(2, 2, 2, 2));

		btnCriarProjetos.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnCriarProjetos.png")));
		panelMenu_expanded.add(btnCriarProjetos, "cell 0 2,growx,aligny center");
		
		btnCriarProjetos.setBorderPainted(false);
		btnCriarProjetos.setContentAreaFilled(false);
		btnCriarProjetos.setFocusPainted(false);
		btnCriarProjetos.setOpaque(false);
		
		
		
		 btnNotificacoes = new JButton("");
		btnNotificacoes.setMargin(new Insets(2, 2, 2, 2));
	
		btnNotificacoes.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnNotificacoes.png")));
		panelMenu_expanded.add(btnNotificacoes, "cell 0 3,growx,aligny center");
		
		btnNotificacoes.setBorderPainted(false);
		btnNotificacoes.setContentAreaFilled(false);
		btnNotificacoes.setFocusPainted(false);
		btnNotificacoes.setOpaque(false);
		
		
		
//		 btnColaboradores = new JButton("");
//		btnColaboradores.setMargin(new Insets(2, 2, 2, 2));
//		
//		btnColaboradores.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnColaboradores.png")));
//		panelMenu_expanded.add(btnColaboradores, "cell 0 4,growx,aligny center");
//		
//		btnColaboradores.setBorderPainted(false);
//		btnColaboradores.setContentAreaFilled(false);
//		btnColaboradores.setFocusPainted(false);
//		btnColaboradores.setOpaque(false);
		
		
		
		 btnPerfil = new JButton("");
		btnPerfil.setMargin(new Insets(2, 2, 2, 2));
		
		btnPerfil.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnPerfil.png")));
		panelMenu_expanded.add(btnPerfil, "cell 0 14,alignx center,growy");
		
		btnPerfil.setBorderPainted(false);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setFocusPainted(false);
		btnPerfil.setOpaque(false);
		
		
		JPanel panel_3 = new TelaInternaInicial();
		panel_3.setBackground(new Color(216, 178, 184));
		panel_3.setLayout(new MigLayout("debug, fill", "[]", "[]"));
		panelActual=panel_3;
		panel_Central.add(panel_3, BorderLayout.CENTER);
		
		
		
		
		panelMenuContracted = new JPanel();
		panelMenuContracted.setBackground(new Color(255, 245, 234));
		
		panelMenuContracted.setLayout(new MigLayout("", "[42px]", "[][][][][][][][][][][][][][][][][][grow][][][][]"));
		//panel_Central.add(panelMenuContracted, BorderLayout.WEST);
		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setMargin(new Insets(2, 2, 2, 2));
		
		btnNewButton.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnPerfilRe.png")));
		panelMenuContracted.add(btnNewButton, "cell 0 20,alignx center,growy");
		
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		
		
		
		
		
		
	}

	

	public JButton getBtnExit() {
		return btnExit;
	}

	public JButton getBtnPerfil() {
		return btnPerfil;
	}

	public JButton getBtnNotificacoes() {
		return btnNotificacoes;
	}

	public JButton getBtnMeusProjetos() {
		return btnMeusProjetos;
	}

	public JButton getBtnAbrirMenu() {
		return btnAbrirMenu;
	}
	
	

	public void abrirMenu() {
		if (menuAberto == false) {
			menuAberto  = true;
			
			panel_Central.remove(panelMenu_expanded);

	        // Novo painel para o lado esquerdo
	        			        // Adiciona o novo painel na mesma posição
			panel_Central.add(panelMenuContracted, BorderLayout.WEST);

			
			
		} else {
			menuAberto = false; 
			
			panel_Central.remove(panelMenuContracted);

	        // Novo painel para o lado esquerdo
	        			        // Adiciona o novo painel na mesma posição
			panel_Central.add(panelMenu_expanded, BorderLayout.WEST);

		}
	    // Atualiza a interface
        revalidate();
        repaint();
		
	
		
	}

	public JButton getBtnCriarProjetos() {
		
		return btnCriarProjetos;
	}
	
	
	public void configurarTela() {
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
        // Recupera as dimensões da tela
		// Dimension screenSize = toolkit.getScreenSize();
        
        // Extrai a largura e altura em pixels
        int largura = (int)this.getSize().getWidth();
        int altura = (int)this.getSize().getHeight();
        
       
        
		this.setPreferredSize(new Dimension(largura, altura));
	}
}