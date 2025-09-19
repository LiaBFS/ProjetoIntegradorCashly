package model;

import java.util.Date;
import java.util.List;

public class Projeto {
	private int id;
	private Date dataCriacao;
	private String descricao;
	private List<LancamentoFinanceiro> fluxoRenda;
	private double saldo;
	//private List<Usuario> colaboradores;
	private String nome;
	
	public Projeto(int id, Date dataCriacao, String descricao, List<LancamentoFinanceiro> fluxoRenda, double saldo) {

		this.id = id;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.descricao = descricao;
		this.fluxoRenda = fluxoRenda;
		this.saldo = saldo;
		//this.colaboradores = colaboradores;
	}
	
	public Projeto() {
		
	}
	
	
//	public List<Usuario> getColaboradores() {
//		return colaboradores;
//	}
//	public void setColaboradores(List<Usuario> colaboradores) {
//		this.colaboradores = colaboradores;
//	}
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
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	

}
