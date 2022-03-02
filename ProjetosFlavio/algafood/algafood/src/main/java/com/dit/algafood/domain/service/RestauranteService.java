package com.dit.algafood.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dit.algafood.domain.entities.Cozinha;
import com.dit.algafood.domain.entities.FormaPagamento;
import com.dit.algafood.domain.entities.Restaurante;
import com.dit.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.dit.algafood.domain.exception.EntityEmUsoException;
import com.dit.algafood.domain.repository.CozinhaRepository;
import com.dit.algafood.domain.repository.FormaPagamentoRepository;
import com.dit.algafood.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Long formaPagamentoId = restaurante.getFormaPagamento().getId();
		
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com código %d", cozinhaId)));
		
		if (cozinha == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cozinha com código %d", cozinhaId));
		}
		restaurante.setCozinha(cozinha);
		
		FormaPagamento formaPagamento = formaPagamentoRepository.buscar(formaPagamentoId);
		if (formaPagamento == null ) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro para forma de pagamento com código %d", formaPagamentoId));	
		}
		restaurante.setFormaPagamento(formaPagamento);
		
		return restauranteRepository.save(restaurante);
	}
	
	public void excluir(Long restauranteId) {
		try {
			restauranteRepository.deleteById(restauranteId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntityEmUsoException(
					String.format("Estado de código %d não pode ser "
							+ "removido, pois esta em uso", restauranteId));  
			
		} catch (EmptyResultDataAccessException e){
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com código %d", restauranteId));
		}
	}	
	
}
