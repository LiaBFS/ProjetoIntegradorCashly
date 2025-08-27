package classesBanco;

import java.util.Date;
import java.util.List;

public class PlanoFinanceiro {
	private int id;
	private Usuario usuario;
	private Date dataInicio;
	private Date dataFim;
	private List<MetaFinanceira> metas;
	public PlanoFinanceiro(int id, Usuario usuario, Date dataInicio, Date dataFim, List<MetaFinanceira> metas) {
		
		this.id = id;
		this.usuario = usuario;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.metas = metas;
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
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public List<MetaFinanceira> getMetas() {
		return metas;
	}
	public void setMetas(List<MetaFinanceira> metas) {
		this.metas = metas;
	}
	
	
	

}
