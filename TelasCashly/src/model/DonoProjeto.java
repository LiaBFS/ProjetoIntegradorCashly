package model;

import java.util.Date;
import java.util.List;

public class DonoProjeto extends Usuario{

	public DonoProjeto(int id, String nome, String email, String senha, Date dataCadastro, List<Projeto> projetos) throws Exception {
		super(id, nome, email, senha, dataCadastro, projetos);
		// TODO Auto-generated constructor stub.
		
	}

}
