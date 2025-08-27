package classesBanco;

import java.util.Date;

public class MetaFinanceira {
	private int id;
	private String descricao;
	private double valorMeta;
	private double valorAtual;
	private Date prazo;
	public MetaFinanceira(int id, String descricao, double valorMeta, double valorAtual, Date prazo) {
		
		this.id = id;
		this.descricao = descricao;
		this.valorMeta = valorMeta;
		this.valorAtual = valorAtual;
		this.prazo = prazo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorMeta() {
		return valorMeta;
	}
	public void setValorMeta(double valorMeta) {
		this.valorMeta = valorMeta;
	}
	public double getValorAtual() {
		return valorAtual;
	}
	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}
	public Date getPrazo() {
		return prazo;
	}
	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}
	
	

}
