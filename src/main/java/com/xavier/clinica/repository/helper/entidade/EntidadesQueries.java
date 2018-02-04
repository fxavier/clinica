package com.xavier.clinica.repository.helper.entidade;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xavier.clinica.model.Entidade;
import com.xavier.clinica.repository.filter.EntidadeFilter;

public interface EntidadesQueries {

	public Optional<Entidade> findByNomeIgnoreCase(String nome);
	
	public Page<Entidade> filtrar(EntidadeFilter filtro, Pageable pageable);
	
}
