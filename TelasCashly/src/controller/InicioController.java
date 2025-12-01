package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;

import model.Projeto;
import model.ProjetoDAO;
import model.Sessao;
import view.TelaInicio;
import view.TelaInternaCriar;
import view.TelaInternaInicial;
import view.TelaInternaPerfil;
import view.TelaInternaProjeto;
import view.TelaInternaProjetos;
import view.TelaInternaRelatorio;


public class InicioController {
	
	TelaInicio telaInicio;
	
	
	public InicioController(TelaInicio telaInicio) {
		this.telaInicio = telaInicio;

	
        this.telaInicio.getBtnAbrirMenu().addActionListener(e -> abrirMenu());
        this.telaInicio.getBtnHome().addActionListener(e -> abrirTelaHome());
        this.telaInicio.getBtnCriarProjetos().addActionListener(e -> abrirTelaCriarProjeto());
        this.telaInicio.getBtnMeusProjetos().addActionListener(e -> abrirTelaMeusProjetos());
        this.telaInicio.getBtnRelatorio().addActionListener(e -> abrirTelaRelatorio());
        this.telaInicio.getBtnPerfil().addActionListener(e -> abrirTelaPerfil());
        this.telaInicio.getBtnExit().addActionListener(e -> sair()); 
	
	}
	
	
	public void sair() {
		telaInicio.dispose();
	}

 
	private void abrirTelaPerfil() {
		TelaInternaPerfil tela = new TelaInternaPerfil();
		UsuarioController usuarioController = new UsuarioController(tela, Sessao.getUsuarioLogado(), this);
	    this.telaInicio.atualizarPainel(tela);

	    this.telaInicio.selecionarBotao(telaInicio.getBtnPerfil());
	    this.telaInicio.atualizarMenuLateral();
	}
	
	private void abrirTelaRelatorio() {
	    TelaInternaRelatorio tela = new TelaInternaRelatorio();
	    
	    // ✅ Cria o controller e carrega os dados do banco
	    RelatorioController relatorioController = new RelatorioController(tela);
	    relatorioController.carregarDadosDoRelatorio();
	    
	    this.telaInicio.atualizarPainel(tela);
	    this.telaInicio.selecionarBotao(telaInicio.getBtnRelatorio());
	    this.telaInicio.atualizarMenuLateral();
	}
	
	
	private void abrirTelaMeusProjetos() {
		TelaInternaProjetos tela = new TelaInternaProjetos();
		ProjetoDAO P = new ProjetoDAO();
		MeusProjetosController controller = new MeusProjetosController(tela, P, this.telaInicio);
		controller.carregarProjetos();
		
		

		this.telaInicio.atualizarPainel(tela);
		
		this.telaInicio.selecionarBotao(telaInicio.getBtnMeusProjetos());
		
		this.telaInicio.atualizarMenuLateral();
	}

	private void abrirTelaHome() {
		TelaInternaProjetos tela = new TelaInternaProjetos();
		ProjetoDAO P = new ProjetoDAO();
		MeusProjetosController projetosController = new MeusProjetosController(tela, P, telaInicio);
	    TelaInternaInicial telaInicial = new TelaInternaInicial();
	    InicialController inicial = new InicialController(telaInicial, projetosController);
	    inicial.colocarProjetoRecente();
	    
	    this.telaInicio.atualizarPainel(telaInicial);
	    
	    this.telaInicio.selecionarBotao(null);
	    
	    this.telaInicio.atualizarMenuLateral();
	    
	 
	    
	}
	
	
	private void abrirTelaCriarProjeto() {
		TelaInternaCriar tela = new TelaInternaCriar();
		ProjetoDAO projetoDAO = new ProjetoDAO();
		CriarProjetoController projetoController = new CriarProjetoController(tela, projetoDAO);
		this.telaInicio.atualizarPainel(tela);
		
		this.telaInicio.selecionarBotao(telaInicio.getBtnCriarProjetos());
		
		this.telaInicio.atualizarMenuLateral();
		
	}

	private void abrirMenu() {
		this.telaInicio.abrirMenu();
		
			}

	public void abrirTela() {
		this.telaInicio.setVisible(true);
		
		this.telaInicio.configurarTela();
		this.abrirTelaHome();
		
	}

}
