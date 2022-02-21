package com.dit.algafood.infrainstructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dit.algafood.domain.entities.FormaPagamento;
import com.dit.algafood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager mananger;
	
	@Override
	public List<FormaPagamento> listar() {
		return mananger.createQuery(" from FormaPagamento ", FormaPagamento.class)
				.getResultList();
	}

	@Override
	public FormaPagamento buscar(Long id) {
		return mananger.find(FormaPagamento.class, id);
	}

	@Transactional
	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return mananger.merge(formaPagamento);
	}

	@Transactional
	@Override
	public void remover(FormaPagamento formaPagamento) {
		formaPagamento = buscar(formaPagamento.getId());
		mananger.remove(formaPagamento);
	}

}
