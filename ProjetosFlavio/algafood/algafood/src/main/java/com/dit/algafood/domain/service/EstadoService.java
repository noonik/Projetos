package com.dit.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dit.algafood.domain.entities.Estado;
import com.dit.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.dit.algafood.domain.exception.EntityEmUsoException;
import com.dit.algafood.domain.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
		return estadoRepository.salvar(estado);
	}
	
	public void excluir(Long estadoId) {
		try {
			estadoRepository.remover(estadoId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntityEmUsoException(
					String.format("Estado de código %d não pode ser "
							+ "removido, pois esta em uso", estadoId));  
			
		} catch (EmptyResultDataAccessException e){
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com código %d", estadoId));
		}
	}	
	
	
	
}
