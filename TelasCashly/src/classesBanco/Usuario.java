package classesBanco;

import java.util.Date;
import java.util.List;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String senhaHash;
	private Date dataCadastro;
	private List<Projeto> projetos;
	
	public Usuario(int id, String nome, String email, String senha, Date dataCadastro, List<Projeto> projetos) throws Exception {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senhaHash = PasswordUtils.md5(senha);
		this.dataCadastro = dataCadastro;
		this.projetos = projetos;
		System.out.println("ENTREI NO CONSTRUTOR 2");
	}
	
	
	public Usuario(String nome, String email, String senha) throws Exception {
        this.nome = nome;
        this.email = email;
        this.senhaHash = PasswordUtils.md5(senha);
        System.out.println("ENTREI NO CONSTRUTOR 2");
    }
	
	public Usuario() {
		System.out.println("entrei no construtor vazio!");
	}

	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenhaHash() { return senhaHash; }

   
    public void setSenha(String senha) throws Exception {
        this.senhaHash = PasswordUtils.md5(senha);
    }

	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public List<Projeto> getProjetos() {
		return projetos;
	}


	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}


}

