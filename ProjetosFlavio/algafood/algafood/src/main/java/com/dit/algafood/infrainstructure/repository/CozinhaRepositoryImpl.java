package com.dit.algafood.infrainstructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dit.algafood.domain.entities.Cozinha;
import com.dit.algafood.domain.repository.CozinhaRepository;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepository {

@PersistenceContext
private EntityManager manager;
	
	@Override
	public List<Cozinha> listar(){
		return  manager.createQuery(" from Cozinha ", Cozinha.class)
				.getResultList();
	}
	
	@Transactional
	@Override
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		Cozinha cozinha = buscar(id);	
		if(cozinha == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(cozinha);
	}

	@Override
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}

	@Override
	public List<Cozinha> listarPorNome(String nome) {
		return manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
				.setParameter("nome", "%" + nome + "%" )
				.getResultList();
	}

}
