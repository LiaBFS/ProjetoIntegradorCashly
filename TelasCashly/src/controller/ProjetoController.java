package controller;

import javax.swing.JOptionPane;

import model.Projeto;
import model.ProjetoDAO;

import view.TelaInternaCriar;
import view.TelaInternaInicial;

public class ProjetoController {
	
	private TelaInternaCriar telaInternaCriar;
	private TelaInternaInicial telaInternaInicial;
	
	private ProjetoDAO projetoDAO;
	
	
	public ProjetoController(TelaInternaCriar telaInternaCriar, ProjetoDAO projetoDAO) {
		
		this.telaInternaCriar = telaInternaCriar;
		this.projetoDAO = projetoDAO;
		
		telaInternaCriar.getBtnCriar().addActionListener(e -> criarProjeto());;
		
		
		}


	private void criarProjeto() {
		
		
		String nome = telaInternaCriar.getTfNomeProjeto().getText().trim();
		String descricao = telaInternaCriar.getTfDescricaoProjeto().getText().trim();
		String saldoTexto = telaInternaCriar.getTfSaldo().getText().trim();

		if (nome.equals(telaInternaCriar.getPlaceholderNomeProjeto()) || descricao.equals(telaInternaCriar.getPlaceholderDescricao())
				|| saldoTexto.equals(telaInternaCriar.getPlaceholderSaldo()) || nome.isEmpty() || descricao.isEmpty()
				|| saldoTexto.isEmpty()) {
			
			
			JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.",
					"Erro na Criação do Projeto", JOptionPane.ERROR_MESSAGE);
			return;
		}

		double saldo = 0.0;
		try {

			saldo = Double.parseDouble(saldoTexto.replace(",", "."));
			
		} catch (NumberFormatException ex) {
			
			JOptionPane.showMessageDialog(null, "Saldo inválido. Digite apenas números!",
					"Erro na Criação do Projeto", JOptionPane.ERROR_MESSAGE);
			return;
		}

	
		Projeto novoProjeto = new model.Projeto();
		novoProjeto.setNome(nome);
		novoProjeto.setDescricao(descricao);
		novoProjeto.setSaldo(saldo);

		projetoDAO.adicionarProjeto(novoProjeto);
		
		telaInternaCriar.getTfNomeProjeto().setText(telaInternaCriar.getPlaceholderNomeProjeto());
		telaInternaCriar.getTfDescricaoProjeto().setText(telaInternaCriar.getPlaceholderDescricao());
		telaInternaCriar.getTfSaldo().setText(telaInternaCriar.getPlaceholderSaldo());
	}


		
	
	
	
	
	

}
