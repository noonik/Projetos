package com.dit.algafood.domain.repository;

import java.util.List;

import com.dit.algafood.domain.entities.Cozinha;

public interface CozinhaRepository {
	
	List<Cozinha> listar();
	Cozinha buscar(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Cozinha cozinha);


}
