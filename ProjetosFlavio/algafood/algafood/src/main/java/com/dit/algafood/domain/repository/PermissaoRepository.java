package com.dit.algafood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dit.algafood.domain.entities.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
	

}
