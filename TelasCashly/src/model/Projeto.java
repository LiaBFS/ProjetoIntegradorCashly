package model;

import java.util.Date;
import java.util.List;

public class Projeto {
	private int id;
	private Date dataCriacao;
	private String descricao;
	private List<LancamentoFinanceiro> fluxoRenda;
	private double valorAtual;
	private double objetivo;
	private CategoriaDeProjeto categoria;
	private String nome;
	private int usuario_id;
	
	public Projeto(int id, Date dataCriacao, String descricao, List<LancamentoFinanceiro> fluxoRenda, double valorAtual, double objetivo, int usuarioID, CategoriaDeProjeto categoria) {

		this.id = id;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.descricao = descricao;
		this.fluxoRenda = fluxoRenda;
		this.valorAtual = valorAtual;
		this.objetivo = objetivo;
		this.usuario_id = usuarioID;
		//this.categoria = categoria;

	}
	
	

	


	public Projeto() {
		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataCriacao() { 
		return dataCriacao; 
	}
    public void setDataCriacao(Date dataCriacao) { 
    	this.dataCriacao = dataCriacao; 
    }
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<LancamentoFinanceiro> getFluxoRenda() {
		return fluxoRenda;
	}
	public void setFluxoRenda(List<LancamentoFinanceiro> fluxoRenda) {
		this.fluxoRenda = fluxoRenda;
	}
	public double getValorAtual() {
		return valorAtual;
	}
	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}
	public double getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(double objetivo) {
		this.objetivo = objetivo;
	}
	public int getUsuarioID() {
		return usuario_id;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuario_id = usuarioID;
	}
	public CategoriaDeProjeto getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaDeProjeto categoria) {
		this.categoria = categoria;
	}

	
	
	

}
