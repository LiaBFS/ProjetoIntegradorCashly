package controller;

import java.text.SimpleDateFormat;

import model.Projeto;
import model.ProjetoDAO;
import view.TelaInternaInicial;

public class InicialController {
	
	TelaInternaInicial tela;
	
	

	public InicialController(TelaInternaInicial tela) {
		
		this.tela = tela;
		
		
		
	}



	public void colocarProjetoRecente() {
		
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
	
	
	

}
