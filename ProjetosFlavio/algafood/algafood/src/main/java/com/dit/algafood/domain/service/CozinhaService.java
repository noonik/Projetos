package com.dit.algafood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dit.algafood.domain.entities.Cozinha;
import com.dit.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.dit.algafood.domain.exception.EntityEmUsoException;
import com.dit.algafood.domain.repository.CozinhaRepository;

@Service
public class CozinhaService {
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
	public List<Cozinha> listar(){
		return cozinhaRepository.findAll();
	}
	
	public Cozinha buscar(Long id) {
		Optional<Cozinha> cozinha = cozinhaRepository.findById(id);
		return cozinha.get();
	}
	
	public Cozinha salvar(Cozinha cozinha) {		
		return cozinhaRepository.save(cozinha);
	}
	
	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.deleteById(cozinhaId);;
			
		} catch (DataIntegrityViolationException e) {
			throw new EntityEmUsoException(
					String.format("Cozinha de código %d não pode ser "
							+ "removida, pois esta em uso", cozinhaId));  
			
		} catch (EmptyResultDataAccessException e){
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cozinha com código %d", cozinhaId));
		}
	}	

}
