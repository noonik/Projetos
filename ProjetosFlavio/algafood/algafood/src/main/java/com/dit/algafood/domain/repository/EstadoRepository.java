package com.dit.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dit.algafood.domain.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
