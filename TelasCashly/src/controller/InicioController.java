package controller;

import java.awt.BorderLayout;

import view.TelaInicio;
import view.TelaInternaCriar;
import view.TelaInternaInicial;

public class InicioController {
	
	TelaInicio telaInicio;
	
	public InicioController(TelaInicio telaInicio) {
		this.telaInicio = telaInicio;

	
        this.telaInicio.getBtnAbrirMenu().addActionListener(e -> abrirMenu());
        this.telaInicio.getBtnHome().addActionListener(e -> abrirTelaHome());
        this.telaInicio.getBtnCriarProjetos().addActionListener(e -> abrirTelaCriarProjeto());

	
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
