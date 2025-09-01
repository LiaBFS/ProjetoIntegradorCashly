package classesBanco;

public class CategoriaGasto {
	private int id;
	private String nome;
	private double orcamentoMaximo;
	public CategoriaGasto(int id, String nome, double orcamentoMaximo) {
	
		this.id = id;
		this.nome = nome;
		this.orcamentoMaximo = orcamentoMaximo;
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
	public double getOrcamentoMaximo() {
		return orcamentoMaximo;
	}
	public void setOrcamentoMaximo(double orcamentoMaximo) {
		this.orcamentoMaximo = orcamentoMaximo;
	}
	
	

}
