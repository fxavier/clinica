package com.xavier.clinica.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xavier.clinica.model.Entidade;
import com.xavier.clinica.repository.helper.entidade.EntidadesQueries;


@Repository
public interface Entidades extends JpaRepository<Entidade, Long>, EntidadesQueries{

	public Optional<Entidade> findByNomeIgnoreCase(String nome);
	
	

}
