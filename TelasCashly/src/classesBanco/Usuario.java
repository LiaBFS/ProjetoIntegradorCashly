package classesBanco;

import java.util.Date;
import java.util.List;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private Date dataCadastro;
	private List<Projeto> projetos;
	
	public Usuario(int id, String nome, String email, String senha, Date dataCadastro, List<Projeto> projetos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.projetos = projetos;
	}
	
	public void cadastrar() {
		System.out.print("Usuário cadastrado!");
	}
   
}
