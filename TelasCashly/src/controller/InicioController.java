package controller;

import java.awt.BorderLayout;

import model.Sessao;
import view.TelaInicio;
import view.TelaInternaCriar;
import view.TelaInternaInicial;
import view.TelaInternaNotificacoes;
import view.TelaInternaPerfil;
import view.TelaInternaProjetos;

public class InicioController {
	
	TelaInicio telaInicio;
	
	public InicioController(TelaInicio telaInicio) {
		this.telaInicio = telaInicio;

	
        this.telaInicio.getBtnAbrirMenu().addActionListener(e -> abrirMenu());
        this.telaInicio.getBtnHome().addActionListener(e -> abrirTelaHome());
        this.telaInicio.getBtnCriarProjetos().addActionListener(e -> abrirTelaCriarProjeto());
        this.telaInicio.getBtnMeusProjetos().addActionListener(e -> abrirTelaMeusProjetos());
        this.telaInicio.getBtnNotificacoes().addActionListener(e -> abrirTelaNotificacoes());
        this.telaInicio.getBtnPerfil().addActionListener(e -> abrirTelaPerfil());
	
	}
	
	
	private void abrirTelaPerfil() {
		TelaInternaPerfil tela = new TelaInternaPerfil();
		UsuarioController usuarioController = new UsuarioController(tela, Sessao.getUsuarioLogado());
	    this.telaInicio.atualizarPainel(tela);

	    this.telaInicio.selecionarBotao(telaInicio.getBtnPerfil());
	    this.telaInicio.atualizarMenuLateral();
	}
	
	private void abrirTelaNotificacoes() {
		TelaInternaNotificacoes tela = new TelaInternaNotificacoes();
		this.telaInicio.atualizarPainel(tela);
		
		this.telaInicio.selecionarBotao(telaInicio.getBtnNotificacoes());
		
		this.telaInicio.atualizarMenuLateral();
	}
	
	
	private void abrirTelaMeusProjetos() {
		TelaInternaProjetos tela = new TelaInternaProjetos();
		this.telaInicio.atualizarPainel(tela);
		
		this.telaInicio.selecionarBotao(telaInicio.getBtnMeusProjetos());
		
		this.telaInicio.atualizarMenuLateral();
	}

	private void abrirTelaHome() {
		TelaInternaInicial tela = new TelaInternaInicial();
		this.telaInicio.atualizarPainel(tela);
		
		this.telaInicio.selecionarBotao(null);
		
		this.telaInicio.atualizarMenuLateral();
		
	}
	
	
	private void abrirTelaCriarProjeto() {
		TelaInternaCriar tela = new TelaInternaCriar();
		this.telaInicio.atualizarPainel(tela);
		
		this.telaInicio.selecionarBotao(telaInicio.getBtnCriarProjetos());
		
		this.telaInicio.atualizarMenuLateral();
		
	}

	private void abrirMenu() {
		this.telaInicio.abrirMenu();
		
			}

	public void abrirTela() {
		this.telaInicio.setVisible(true);
		
	}

}
