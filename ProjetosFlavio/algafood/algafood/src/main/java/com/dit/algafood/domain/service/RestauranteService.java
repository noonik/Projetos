package com.dit.algafood.domain.service;

import java.math.BigDecimal;
import java.util.List;

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
		BigDecimal taxaFreteAtual = restaurante.getTaxaFrete();
		
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		
		FormaPagamento formaPagamento = formaPagamentoRepository.buscar(formaPagamentoId);
		
		if (taxaFreteAtual != null) {
			Restaurante restaurante1 = restauranteRepository.buscar(restaurante.getId());
			BigDecimal taxaFrete = restaurante1.getTaxaFrete();
			restaurante.setTaxaFrete(taxaFrete);
		}
		
		if (formaPagamento == null ) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro para forma de pagamento com código %d", formaPagamentoId));	
		}
		restaurante.setFormaPagamento(formaPagamento);
		
		if (cozinha == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cozinha com código %d", cozinhaId));
		}
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.salvar(restaurante);
	}
	
	public List<Restaurante> listar(){
		return restauranteRepository.listar();
	}
	
	public Restaurante buscar(Long id) {
		return restauranteRepository.buscar(id);
	}
	
	public void excluir(Long restauranteId) {
		try {
			restauranteRepository.remover(restauranteId);
			
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
