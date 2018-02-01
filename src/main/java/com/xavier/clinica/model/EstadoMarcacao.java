package com.xavier.clinica.model;

public enum EstadoMarcacao {
	
	PRESENTES("Presentes"),
	ATRASADOS("Atrasados"),
	FALTARAM("Faltaram"),
	CANCELADAS("Canceladas"),
	EFECTUADAS("Efectuadas");
	
	private String descricao;
	
	private EstadoMarcacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
