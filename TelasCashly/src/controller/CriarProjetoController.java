package controller;

import model.CategoriaDeProjeto;
import model.Projeto;
import model.ProjetoDAO;
import model.Sessao;
import view.*;

public class CriarProjetoController {
	
	private TelaInternaCriar telaInternaCriar;
	private TelaInternaInicial telaInternaInicial;
	private ProjetoDAO projetoDAO;
	
	public CriarProjetoController(TelaInternaCriar telaInternaCriar, ProjetoDAO projetoDAO) {
		this.telaInternaCriar = telaInternaCriar;
		this.projetoDAO = projetoDAO;
		
		telaInternaCriar.getBtnCriar().addActionListener(e -> criarProjeto());
		popularComboBoxCategorias();
	}
	
	private void popularComboBoxCategorias() {
		for (CategoriaDeProjeto categoria : CategoriaDeProjeto.values()) {
			telaInternaCriar.getCbCategoria().addItem(categoria);
		} 
		
		if (telaInternaCriar.getCbCategoria().getItemCount() > 0) {
			telaInternaCriar.getCbCategoria().setSelectedIndex(0);
		}
	}
	
	private void criarProjeto() {
		String nome = telaInternaCriar.getTfNomeProjeto().getText().trim();
		String descricao = telaInternaCriar.getTfDescricaoProjeto().getText().trim();
		String saldoTexto = telaInternaCriar.getTfSaldo().getText().trim();
		String objetivoTexto = telaInternaCriar.getTfObjetivo().getText().trim();
		CategoriaDeProjeto categoria = (CategoriaDeProjeto) telaInternaCriar.getCbCategoria().getSelectedItem();
		
		// Validar campos obrigatórios
		if (nome.equals(telaInternaCriar.getPlaceholderNomeProjeto()) || 
		    descricao.equals(telaInternaCriar.getPlaceholderDescricao()) ||
		    saldoTexto.equals(telaInternaCriar.getPlaceholderSaldo()) || 
		    objetivoTexto.equals(telaInternaCriar.getPlaceholderObjetivo()) ||
		    nome.isEmpty() || descricao.isEmpty() || saldoTexto.isEmpty() || objetivoTexto.isEmpty()) {
			
			CamposObrigatoriosCadastro.mostrar(); // ✅ SUBSTITUÍDO (reutilizando)
			return;
		}
		
		// Validar categoria
		if (categoria == null) {
			SelecioneCategoria.mostrar(); // ✅ SUBSTITUÍDO
			return;
		}
		
		// Converter saldo
		double valorAtual = 0.0;
		try {
			valorAtual = Double.parseDouble(saldoTexto.replace(",", "."));
		} catch (NumberFormatException ex) {
			SaldoInvalido.mostrar(); // ✅ SUBSTITUÍDO
			return;
		}
		
		// Converter objetivo
		double objetivo = 0.0;
		try {
			objetivo = Double.parseDouble(objetivoTexto.replace(",", "."));
		} catch (NumberFormatException ex) {
			ObjetivoInvalido.mostrar(); // ✅ SUBSTITUÍDO
			return;
		}
		
		// Validar se objetivo é maior que saldo atual
		if (objetivo <= valorAtual) {
			ObjetivoMaiorQueSaldo.mostrar(); // ✅ SUBSTITUÍDO
			return;
		}
		
		// Criar projeto
		Projeto novoProjeto = new Projeto();
		novoProjeto.setNome(nome);
		novoProjeto.setDescricao(descricao);
		novoProjeto.setValorAtual(valorAtual);
		novoProjeto.setObjetivo(objetivo);
		novoProjeto.setUsuarioID(Sessao.getUsuarioLogado().getId());
		novoProjeto.setCategoria(categoria);
		
		try {
			projetoDAO.adicionarProjeto(novoProjeto);
			ProjetoCriado.mostrar(); // ✅ SUBSTITUÍDO
			limparCampos();
		} catch (Exception ex) {
			// Erro ao criar - pode criar um JFrame específico se necessário
			ex.printStackTrace();
		}
	}
	
	private void limparCampos() {
		telaInternaCriar.getTfNomeProjeto().setText(telaInternaCriar.getPlaceholderNomeProjeto());
		telaInternaCriar.getTfDescricaoProjeto().setText(telaInternaCriar.getPlaceholderDescricao());
		telaInternaCriar.getTfSaldo().setText(telaInternaCriar.getPlaceholderSaldo());
		telaInternaCriar.getTfObjetivo().setText(telaInternaCriar.getPlaceholderObjetivo());
		
		if (telaInternaCriar.getCbCategoria().getItemCount() > 0) {
			telaInternaCriar.getCbCategoria().setSelectedIndex(0);
		}
	}
}
