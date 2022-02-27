package com.dit.algafood.domain.repository;

import java.util.List;

import com.dit.algafood.domain.entities.Cozinha;

public interface CozinhaRepository {
	
	List<Cozinha> listar();
	List<Cozinha> listarPorNome(String nome);	
	Cozinha buscar(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Long id);


}
