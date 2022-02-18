package com.dit.algafood.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dit.algafood.domain.entities.Cozinha;

@Component
public class CadastroCozinha {
	
	private EntityManager manager;
	
	@Autowired
	public CadastroCozinha(EntityManager manager) {
		this.manager = manager;
	}

	public List<Cozinha> listar(){
		return  manager.createQuery(" from Cozinha ", Cozinha.class)
				.getResultList();
	}
	
	@Transactional
	public Cozinha buscar(long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Transactional
	public void remover(Cozinha cozinha) {
		cozinha = buscar(cozinha.getId());
		manager.remove(cozinha);
	}
	
	
}
