package com.dit.algafood.domain.repository;

import java.util.List;

import com.dit.algafood.domain.entities.Permissao;

public interface PermissaoRepository {
		
	List<Permissao> listar();
	Permissao buscar(Long id);
	Permissao salvar(Permissao permissao);
	void remover(Permissao permissao);

}
