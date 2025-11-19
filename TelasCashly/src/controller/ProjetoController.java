package controller;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.List;
import model.LancamentoFinanceiro;
import model.LancamentoFinanceiroDAO;
import model.Projeto;
import model.ProjetoDAO;
import view.TelaInternaEscolhaGrafico;
import view.TelaInternaInicial;
import view.TelaInternaLancamentos;
import view.TelaInternaProjeto;

public class ProjetoController {
	
	private TelaInternaProjeto tela;
	private TelaInternaInicial telaInicio;
	private ProjetoDAO projetoDAO;
	private LancamentoFinanceiroDAO lancamentoDAO;
	private Projeto projetoAtual;
	
	public ProjetoController(TelaInternaProjeto tela, ProjetoDAO projetoDAO, Projeto projeto) {
		
		this.tela = tela;
		this.projetoDAO = projetoDAO;
		this.projetoAtual = projeto;
		this.lancamentoDAO = new LancamentoFinanceiroDAO();
		
		// Configurar botão de adicionar lançamento
		this.tela.getBtnAdicionarLancamento().addActionListener(e -> abrirPopUpLancamento());
		
		// Carregar dados do projeto na tela
		carregarDadosProjeto();
		 
		// Carregar lançamentos na tabela
		carregarLancamentosNaTabela();
	}
	
	private void carregarDadosProjeto() {
		if (projetoAtual != null) {
			tela.getLblNomeProjeto().setText(projetoAtual.getNome());
			tela.getLblDescricaoProjeto().setText(projetoAtual.getDescricao());
			
			// Atualizar valores financeiros
			double valorAtual = lancamentoDAO.obterValorTotalProjeto(projetoAtual.getId());
			tela.getLblDataProjeto().setText(String.format("Total R$ %.2f", valorAtual));
			tela.getLblObjetivoR().setText(String.format("Objetivo R$ %.2f", projetoAtual.getObjetivo()));
		}
	}
	
	public void carregarLancamentosNaTabela() {
		if (projetoAtual == null) return;
		
		// Obter lançamentos do banco de dados
		List<LancamentoFinanceiro> lancamentos = lancamentoDAO.listarLancamentosPorProjeto(projetoAtual.getId());
		
		// Obter modelo da tabela
		DefaultTableModel modelo = (DefaultTableModel) tela.getTable().getModel();
		
		// Limpar tabela
		modelo.setRowCount(0);
		
		// Formato de data
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		// Adicionar lançamentos na tabela
		for (LancamentoFinanceiro lancamento : lancamentos) {
			Object[] linha = new Object[2];
			linha[0] = String.format("R$ %.2f", lancamento.getValor());
			linha[1] = formato.format(lancamento.getData());
			modelo.addRow(linha);
		}
		
		// Atualizar os valores do projeto na tela
		carregarDadosProjeto();
	}
	
	private void abrirPopUpLancamento() {
		TelaInternaLancamentos tela = new TelaInternaLancamentos();
		LancamentoController controller = new LancamentoController(
			tela, 
			projetoAtual.getId(), 
			this.tela, 
			this
		);
		
		tela.setVisible(true);
	}

	// Método para obter a tabela (adicionar getter se não existir)
	public JTable getTable() {
		return tela.getTable();
	}
}