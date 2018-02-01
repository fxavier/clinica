package com.xavier.clinica.repository.helper.banco;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xavier.clinica.model.Banco;
import com.xavier.clinica.repository.filter.BancoFilter;

public interface BancosQueries {
	
	public Page<Banco> filtrar(BancoFilter filtro, Pageable pageable);

}
