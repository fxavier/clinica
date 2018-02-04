package com.xavier.clinica.repository.helper.clinica;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xavier.clinica.model.Clinica;
import com.xavier.clinica.repository.filter.ClinicaFilter;

public interface ClinicasQueries {
	
	public Page<Clinica> filtrar(ClinicaFilter filtro, Pageable pageable);

}
