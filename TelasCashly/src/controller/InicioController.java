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
import view.TelaRelatorio;

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
		TelaRelatorio tela = new TelaRelatorio();
		this.telaInicio.atualizarPainel(tela);
		
		this.telaInicio.selecionarBotao(telaInicio.getBtnRelatorio());
		
		this.telaInicio.atualizarMenuLateral();
	}
	
	
	private void abrirTelaMeusProjetos() {
		TelaInternaProjetos tela = new TelaInternaProjetos();
		ProjetoDAO P = new ProjetoDAO();
		MeusProjetosController projetosController = new MeusProjetosController(tela, P, telaInicio);

		this.telaInicio.atualizarPainel(tela);
		
		this.telaInicio.selecionarBotao(telaInicio.getBtnMeusProjetos());
		
		this.telaInicio.atualizarMenuLateral();
	}

	private void abrirTelaHome() {
	    TelaInternaInicial tela = new TelaInternaInicial();
	    this.telaInicio.atualizarPainel(tela);
	    this.telaInicio.selecionarBotao(null);
	    this.telaInicio.atualizarMenuLateral();

	 
	    ProjetoDAO projetoDAO = new ProjetoDAO();
	    Projeto projetoRecente = projetoDAO.buscarProjetoRecente();

	    
	    if (projetoRecente != null) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        String dataFormatada = sdf.format(projetoRecente.getDataCriacao());

	        tela.atualizarProjetoRecente(
	            projetoRecente.getNome(),
	            projetoRecente.getDescricao(),
	            dataFormatada
	        );
	    } else {
	        tela.atualizarProjetoRecente("Nenhum Projeto Cadastrado...", "Crie um Projeto para desbloquear a adição de Metas e visualização de Gráficos!", "-");
	    }
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
