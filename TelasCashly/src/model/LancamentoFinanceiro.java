package model;

import java.util.Date;

public class LancamentoFinanceiro {
	private int id;
	private Date data;
	private double valor;

	
	public LancamentoFinanceiro(int id, Date data, double valor) {

		this.id = id;
		this.data = data;
		this.valor = valor;
		
		
		
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

	
	

}
