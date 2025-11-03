package model;

import java.util.Date;

public class LancamentoFinanceiro {
	private int id;
	private Date data;
	private double valor;
	private boolean status;
	private String descricao;
	private CategoriaGasto categoria;
	
	public LancamentoFinanceiro(int id, Date data, double valor, boolean status, String descricao,
			CategoriaGasto categoria) {

		this.id = id;
		this.data = data;
		this.valor = valor;
		this.status = status;
		this.descricao = descricao;
		this.categoria = categoria;
		
	}
	
	public LancamentoFinanceiro() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public CategoriaGasto getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaGasto categoria) {
		this.categoria = categoria;
	}	
	
	

}
