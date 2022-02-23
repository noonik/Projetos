package com.dit.algafood.domain.repository;

import java.util.List;

import com.dit.algafood.domain.entities.Cidade;

public interface CidadeRepository {
	
	List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Cidade cidade);

}