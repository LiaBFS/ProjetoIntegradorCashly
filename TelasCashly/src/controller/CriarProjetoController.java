package controller;

import javax.swing.JOptionPane;
import model.CategoriaDeProjeto;
import model.Projeto;
import model.ProjetoDAO;
import model.Sessao;
import view.TelaInternaCriar;
import view.TelaInternaInicial;

public class CriarProjetoController {
	
	private TelaInternaCriar telaInternaCriar;
	private TelaInternaInicial telaInternaInicial;
	private ProjetoDAO projetoDAO;
	
	public CriarProjetoController(TelaInternaCriar telaInternaCriar, ProjetoDAO projetoDAO) {
		
		this.telaInternaCriar = telaInternaCriar;
		this.projetoDAO = projetoDAO;
		
		// Configurar botão criar
		telaInternaCriar.getBtnCriar().addActionListener(e -> criarProjeto());
		
		// Popular o ComboBox com as categorias
		popularComboBoxCategorias();
	}
	
	private void popularComboBoxCategorias() {
		// Adicionar todas as categorias do enum no ComboBox
		for (CategoriaDeProjeto categoria : CategoriaDeProjeto.values()) {
			telaInternaCriar.getCbCategoria().addItem(categoria);
		}
		
		// Definir primeira categoria como selecionada por padrão
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
		
		// Validar campos
		if (nome.equals(telaInternaCriar.getPlaceholderNomeProjeto()) || 
		    descricao.equals(telaInternaCriar.getPlaceholderDescricao()) ||
		    saldoTexto.equals(telaInternaCriar.getPlaceholderSaldo()) || 
		    objetivoTexto.equals(telaInternaCriar.getPlaceholderObjetivo()) ||
		    nome.isEmpty() || descricao.isEmpty() || saldoTexto.isEmpty() || objetivoTexto.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.",
					"Erro na Criação do Projeto", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// Validar categoria
		if (categoria == null) {
			JOptionPane.showMessageDialog(null, "Selecione uma categoria para o projeto.",
					"Erro na Criação do Projeto", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// Converter saldo
		double valorAtual = 0.0;
		try {
			valorAtual = Double.parseDouble(saldoTexto.replace(",", "."));
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Saldo inválido. Digite apenas números.",
					"Erro na Criação do Projeto", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// Converter objetivo
		double objetivo = 0.0;
		try {
			objetivo = Double.parseDouble(objetivoTexto.replace(",", "."));
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Valor de Objetivo inválido. Digite apenas números.",
					"Erro na Criação do Projeto", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// Validar se objetivo é maior que saldo atual
		if (objetivo <= valorAtual) {
			JOptionPane.showMessageDialog(null, "O objetivo deve ser maior que o saldo atual.",
					"Erro na Criação do Projeto", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// Criar projeto
		Projeto novoProjeto = new Projeto();
		novoProjeto.setNome(nome);
		novoProjeto.setDescricao(descricao);
		novoProjeto.setValorAtual(valorAtual);
		novoProjeto.setObjetivo(objetivo);
		novoProjeto.setUsuarioID(Sessao.getUsuarioLogado().getId());
		novoProjeto.setCategoria(categoria); // IMPORTANTE: Setar a categoria
		
		try {
			projetoDAO.adicionarProjeto(novoProjeto);
			JOptionPane.showMessageDialog(null, "Projeto criado com sucesso!");
			
			// Limpar campos
			limparCampos();
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao criar projeto: " + ex.getMessage(),
					"Erro na Criação do Projeto", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}
	
	private void limparCampos() {
		telaInternaCriar.getTfNomeProjeto().setText(telaInternaCriar.getPlaceholderNomeProjeto());
		telaInternaCriar.getTfDescricaoProjeto().setText(telaInternaCriar.getPlaceholderDescricao());
		telaInternaCriar.getTfSaldo().setText(telaInternaCriar.getPlaceholderSaldo());
		telaInternaCriar.getTfObjetivo().setText(telaInternaCriar.getPlaceholderObjetivo());
		
		// Resetar ComboBox para primeira opção
		if (telaInternaCriar.getCbCategoria().getItemCount() > 0) {
			telaInternaCriar.getCbCategoria().setSelectedIndex(0);
		}
	}
}