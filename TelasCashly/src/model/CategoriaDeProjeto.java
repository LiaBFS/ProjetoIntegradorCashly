package model;

public enum CategoriaDeProjeto {

	SAUDE_BEMESTAR("Saúde e Bem-Estar"), BENS_AQUISICOES("Bens e Aquisições"), VIAGENS_LAZER("Viagens e Lazer"), EDUCACAO_DESENVOLVIMENTO("Educação e Desenvolvimento"), 
	RESERVA_FINANCEIRA("Reserva Financeira"), FAMILIA_RELACIONAMENTOS("Família e Relacionamentos");
	
	String descricao;
	
	private CategoriaDeProjeto(String desc) {
		this.descricao=desc;
		// TODO Auto-generated constructor stub
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
	
	
}
