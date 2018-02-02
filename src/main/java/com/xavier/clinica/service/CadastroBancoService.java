package com.xavier.clinica.service;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xavier.clinica.model.Banco;
import com.xavier.clinica.repository.Bancos;
import com.xavier.clinica.service.exception.CadastroBancoException;
import com.xavier.clinica.service.exception.ImpossivelExcluirBancoException;

@Service
public class CadastroBancoService {
	
	@Autowired
	private Bancos bancos;
	
	@Transactional
	public void salvar(Banco banco) {
		Optional<Banco> bancoExistente = bancos.findByNomeIgnoreCase(banco.getNome());
		
		if(bancoExistente.isPresent() && banco.isNovo()) {
			throw new CadastroBancoException("Esse banco ja existe na base de dados");
		}
		
		bancos.save(banco);
	}
	
	@Transactional
	public void excluir(Banco banco) {
		try {
			bancos.delete(banco);
			bancos.flush();
		} catch(PersistenceException e) {
			throw new ImpossivelExcluirBancoException("Não é possível excluir o banco, por favor contacte o administrador");
		}
	}

}
