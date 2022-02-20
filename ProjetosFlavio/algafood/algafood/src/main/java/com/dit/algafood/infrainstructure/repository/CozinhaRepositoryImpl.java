package com.dit.algafood.infrainstructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dit.algafood.domain.entities.Cozinha;
import com.dit.algafood.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

@PersistenceContext
private EntityManager manager;
	
	public List<Cozinha> listar(){
		return  manager.createQuery(" from Cozinha ", Cozinha.class)
				.getResultList();
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


	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}

}
