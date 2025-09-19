package model;

import java.util.Date;

public class LogAcesso {
	private int id;
	private Usuario usuario;
	private Date dataHora;
	public LogAcesso(int id, Usuario usuario, Date dataHora) {
		
		this.id = id;
		this.usuario = usuario;
		this.dataHora = dataHora;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	

}
