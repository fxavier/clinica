package com.xavier.clinica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xavier.clinica.model.Banco;
import com.xavier.clinica.repository.helper.banco.BancosQueries;

@Repository
public interface Bancos extends JpaRepository<Banco, Long>, BancosQueries{
	
	public Optional<Banco> findByNomeIgnoreCase(String nome);

	public Banco findBycodigo(Long codigo);

}
