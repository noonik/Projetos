package com.dit.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.dit.algafood.domain.entities.Restaurante;

public interface RestauranteRepositoryQuery {

	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

	List<Restaurante> findComFreteGratis(String nome);
	
}