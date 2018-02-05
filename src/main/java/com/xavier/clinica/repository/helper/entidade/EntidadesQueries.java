package com.xavier.clinica.repository.helper.entidade;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xavier.clinica.model.Entidade;
import com.xavier.clinica.repository.filter.EntidadeFilter;

public interface EntidadesQueries {

	public Page<Entidade> filtrar(EntidadeFilter filtro, Pageable pageable);
	
}
