package controller;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.List;
import model.LancamentoFinanceiro;
import model.LancamentoFinanceiroDAO;
import model.Projeto;
import model.ProjetoDAO;
import view.ObjetivoAlcancado;
import view.ObjetivoJaAlcancado;
import view.TelaInternaInicial;
import view.TelaInternaLancamentos;
import view.TelaInternaProjeto;

public class ProjetoController {
	
	private TelaInternaProjeto tela;
	private TelaInternaInicial telaInicio;
	private ProjetoDAO projetoDAO;
	private LancamentoFinanceiroDAO lancamentoDAO;
	private Projeto projetoAtual;
	
	// Flag para controlar se o objetivo acabou de ser alcançado
	private boolean objetivoRecemAlcancado = false;
	
	public ProjetoController(TelaInternaProjeto tela, ProjetoDAO projetoDAO, Projeto projeto) {
		
		this.tela = tela;
		this.projetoDAO = projetoDAO;
		this.projetoAtual = projeto;
		this.lancamentoDAO = new LancamentoFinanceiroDAO();
		
		this.tela.getBtnAdicionarLancamento().addActionListener(e -> abrirPopUpLancamento());
		
		carregarDadosProjeto();
		carregarLancamentosNaTabela();
		
		// Verificar se o objetivo já foi alcançado ao abrir a tela
		verificarObjetivoInicial();
	}
	
	/**
	 * Verifica se o objetivo já estava alcançado ao abrir a tela
	 */
	private void verificarObjetivoInicial() {
		double valorAtual = lancamentoDAO.obterValorTotalProjeto(projetoAtual.getId());
		double objetivo = projetoAtual.getObjetivo();
		
		// Se já estava alcançado, não é "recém alcançado"
		if (valorAtual >= objetivo) {
			objetivoRecemAlcancado = false;
		}
	}
	
	private void carregarDadosProjeto() {
		if (projetoAtual != null) {
			tela.getLblNomeProjeto().setText(projetoAtual.getNome());
			tela.getLblDescricaoProjeto().setText(projetoAtual.getDescricao());
			
			double valorAtual = lancamentoDAO.obterValorTotalProjeto(projetoAtual.getId());
			tela.getLblDataProjeto().setText(String.format("Total R$ %.2f", valorAtual));
			tela.getLblObjetivoR().setText(String.format("Objetivo R$ %.2f", projetoAtual.getObjetivo()));
		}
	}
	
	public void carregarLancamentosNaTabela() {
		if (projetoAtual == null) return;
		
		// Verificar se o objetivo ACABOU de ser alcançado (antes não estava, agora está)
		double valorAnterior = lancamentoDAO.obterValorTotalProjeto(projetoAtual.getId());
		
		List<LancamentoFinanceiro> lancamentos = lancamentoDAO.listarLancamentosPorProjeto(projetoAtual.getId());
		
		DefaultTableModel modelo = (DefaultTableModel) tela.getTable().getModel();
		modelo.setRowCount(0);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		for (LancamentoFinanceiro lancamento : lancamentos) {
			Object[] linha = new Object[2];
			linha[0] = String.format("R$ %.2f", lancamento.getValor());
			linha[1] = formato.format(lancamento.getData());
			modelo.addRow(linha);
		}
		
		carregarDadosProjeto();
		
		// Verificar se o objetivo foi alcançado após adicionar lançamento
		double valorAtual = lancamentoDAO.obterValorTotalProjeto(projetoAtual.getId());
		double objetivo = projetoAtual.getObjetivo();
		
		// Se alcançou o objetivo e não tinha alcançado antes, marcar como recém alcançado
		if (valorAtual >= objetivo && valorAnterior < objetivo) {
			objetivoRecemAlcancado = true;
		}
	}
	
	private void abrirPopUpLancamento() {
		// Verificar se o objetivo foi alcançado
		double valorAtual = lancamentoDAO.obterValorTotalProjeto(projetoAtual.getId());
		double objetivo = projetoAtual.getObjetivo();
		
		if (valorAtual >= objetivo) {
			JFrame frameParent = (JFrame) SwingUtilities.getWindowAncestor(tela);
			
			// Se acabou de alcançar, mostra mensagem de parabéns
			if (objetivoRecemAlcancado) {
				ObjetivoAlcancado.mostrar(frameParent);
				objetivoRecemAlcancado = false; // Marca que já mostrou a mensagem
			} else {
				// Se já tinha alcançado antes, mostra mensagem simples
				ObjetivoJaAlcancado.mostrar(frameParent);
			}
		} else {
			// Objetivo não alcançado - abrir tela de lançamento normalmente
			TelaInternaLancamentos telaLancamento = new TelaInternaLancamentos();
			LancamentoController controller = new LancamentoController(
				telaLancamento, 
				projetoAtual.getId(), 
				this.tela, 
				this
			);
			
			telaLancamento.setVisible(true);
		}
	}

	public JTable getTable() {
		return tela.getTable();
	}
}