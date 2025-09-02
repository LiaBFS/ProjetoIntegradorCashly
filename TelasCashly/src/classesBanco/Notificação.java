package classesBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

public class Notificação {
	private int id;
	private String mensagem;
	private Date dataEnvio;
	private String tipo;
	private Usuario usuario;
	
	public Notificação(int id, String mensagem, Date dataEnvio, String tipo, Usuario usuario) {

		this.id = id;
		this.mensagem = mensagem;
		this.dataEnvio = dataEnvio;
		this.tipo = tipo;
		this.usuario = usuario;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public Date getDataEnvio() {
		return dataEnvio;
	}


	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
