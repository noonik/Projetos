package com.dit.algafood.domain.service;

import java.util.List;
import java.util.Optional;

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
	
	private static final String MSG_ESTADO_EM_USO 
			= "estado de código %d não pode ser "
			+ "removido, pois esta em uso";

	private static final String MSG_ESTADO_NAO_ENCONTRADO 
			= "Não existe cadastro de estado com código %d";
	
	private static final String MSG_CIDADE_NAO_ENCONTRADO 
	= "Não existe cadastro de cidade com código %d";
	

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
					String.format(MSG_ESTADO_EM_USO, cidadeId));  
			
		} catch (EmptyResultDataAccessException e){
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_ESTADO_NAO_ENCONTRADO, cidadeId));
		}
	}	
	
	public Cidade localizarCidade(Long cidadeId) {
		return cidadeRepository.findById(cidadeId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(MSG_CIDADE_NAO_ENCONTRADO));
	}
	
	
}
