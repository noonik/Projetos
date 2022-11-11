package com.dit.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dit.algafood.domain.entities.Estado;
import com.dit.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.dit.algafood.domain.exception.EntityEmUsoException;
import com.dit.algafood.domain.exception.EstadoNaoEncontradoException;
import com.dit.algafood.domain.repository.EstadoRepository;

@Service
public class EstadoService {
	
	private static final String ESTADO_EM_USO 
	= "Estado de código %d não pode ser removido, pois esta em uso";

	@Autowired
	EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public void excluir(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntityEmUsoException(
					String.format(ESTADO_EM_USO, estadoId));  
			
		} catch (EmptyResultDataAccessException e){
			throw new EstadoNaoEncontradoException(estadoId);
		}
	}	
	
	
	public Estado localizarEstado(Long estadoId) {
		return estadoRepository.findById(estadoId)
				.orElseThrow(() -> new EstadoNaoEncontradoException(estadoId));
	}
	
	
	
}
