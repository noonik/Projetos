package com.dit.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dit.algafood.domain.entities.Cidade;
import com.dit.algafood.domain.entities.Estado;
import com.dit.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.dit.algafood.domain.exception.EntityEmUsoException;
import com.dit.algafood.domain.repository.CidadeRepository;
import com.dit.algafood.domain.repository.EstadoRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Cidade> listar(){
		return cidadeRepository.listar();
	}
	
	public Cidade buscar(Long id) {
		return cidadeRepository.buscar(id);
	}

	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscar(estadoId);
		
		if (estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com o código", estadoId));
		}
		cidade.setEstado(estado);
		
		return cidadeRepository.salvar(cidade);
	}
	
	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.remover(cidadeId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntityEmUsoException(
					String.format("Estado de código %d não pode ser "
							+ "removido, pois esta em uso", cidadeId));  
			
		} catch (EmptyResultDataAccessException e){
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com código %d", cidadeId));
		}
	}	
	
	
}
