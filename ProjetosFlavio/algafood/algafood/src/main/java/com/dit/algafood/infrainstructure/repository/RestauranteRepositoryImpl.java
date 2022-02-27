package com.dit.algafood.infrainstructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dit.algafood.domain.entities.Restaurante;
import com.dit.algafood.domain.repository.RestauranteRepository;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> listar(){
		return  manager.createQuery(" from Restaurante ", Restaurante.class)
				.getResultList();
	}
	
	@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}

	@Transactional
	@Override
	public Restaurante salvar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		Restaurante restaurante = buscar(id);
		if (restaurante == null ) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(restaurante);
	}

}
