package com.xavier.clinica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xavier.clinica.model.Entidade;
import com.xavier.clinica.repository.Entidades;
import com.xavier.clinica.service.exception.CadastroEntidadeException;

@Service
public class EntidadeService {
	
	@Autowired
	private Entidades entidades;
	
	@Transactional
	public void salvar(Entidade entidade) {
		Optional<Entidade> entidadeExistente = entidades.findByNomeIgnoreCase(entidade.getNome());
		if(entidadeExistente.isPresent() && entidade.isNova()) {
			throw new CadastroEntidadeException("Entidade com esse nome ja existe na base de dados");
		}
		
		entidades.save(entidade);
	}

	
}
