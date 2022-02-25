package com.dit.algafood.domain.repository;

import java.util.List;

import com.dit.algafood.domain.entities.Estado;

public interface EstadoRepository {
	
	List<Estado> listar();
	Estado buscar(Long id);
	Estado salvar(Estado estado);
	void remover(Long id);


}
