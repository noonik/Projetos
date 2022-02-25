package com.dit.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dit.algafood.domain.entities.Restaurante;
import com.dit.algafood.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		return restauranteRepository.salvar(restaurante);
	}
	
	public List<Restaurante> listar(){
		return restauranteRepository.listar();
	}
	
	public Restaurante buscar(Long id) {
		return restauranteRepository.buscar(id);
	}
	
	public void remover(Restaurante restaurante) {
		restauranteRepository.remover(restaurante);
	}
	
}
