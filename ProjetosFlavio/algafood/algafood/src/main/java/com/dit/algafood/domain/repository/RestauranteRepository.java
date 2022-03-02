package com.dit.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dit.algafood.domain.entities.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
