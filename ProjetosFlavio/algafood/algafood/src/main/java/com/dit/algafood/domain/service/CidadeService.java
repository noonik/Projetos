package com.dit.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dit.algafood.domain.entities.Cidade;
import com.dit.algafood.domain.entities.Estado;
import com.dit.algafood.domain.exception.CidadeNaoEncontradaException;
import com.dit.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.dit.algafood.domain.exception.EntityEmUsoException;
import com.dit.algafood.domain.repository.CidadeRepository;

@Service
public class CidadeService {
	
	private static final String MSG_CIDADE_EM_USO 
			= "cidade de código %d não pode ser "
			+ "removido, pois esta em uso";

	

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoService estadoService;
	
	
	public List<Cidade> listar(){
		return cidadeRepository.findAll();
	}
	
	public Cidade buscar(Long id) {
		return localizarCidade(id);
	}

	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoService.localizarEstado(estadoId);
		cidade.setEstado(estado);	
		return cidadeRepository.save(cidade);
	}
	
	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntityEmUsoException(
					String.format(MSG_CIDADE_EM_USO, cidadeId));  
			
		} catch (EmptyResultDataAccessException e){
			throw new CidadeNaoEncontradaException(cidadeId);
		}
	}	
	
	public Cidade localizarCidade(Long cidadeId) {
		return cidadeRepository.findById(cidadeId)
				.orElseThrow(() -> new CidadeNaoEncontradaException(cidadeId));
	}
	
	
}
