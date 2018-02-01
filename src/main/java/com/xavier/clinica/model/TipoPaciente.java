package com.xavier.clinica.model;

public enum TipoPaciente {

	GENERICO("Genérico"),
	EFECTIVO("Efectivo");
	
	private String descricao;
	
	TipoPaciente(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
		
}
