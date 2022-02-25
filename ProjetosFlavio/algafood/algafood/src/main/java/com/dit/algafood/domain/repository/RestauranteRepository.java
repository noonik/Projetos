package com.dit.algafood.domain.repository;

import java.util.List;

import com.dit.algafood.domain.entities.Cozinha;
import com.dit.algafood.domain.entities.Restaurante;

public interface RestauranteRepository {
	
	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Long id);

}
