package com.xavier.clinica.model;

public enum EstadoCivil {
	
	CASADO("Casado"),
	SOLTEIRO("Solteiro"),
	UNIAO_FACTOS("União de Factos");
	
	private String descricao;
	
	private EstadoCivil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
