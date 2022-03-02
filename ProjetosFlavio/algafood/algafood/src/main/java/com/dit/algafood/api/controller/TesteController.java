package com.dit.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dit.algafood.domain.entities.Cozinha;
import com.dit.algafood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
		@GetMapping("/cozinhas/por-nome")
		public List<Cozinha> listCozinhasPorNome(String nome){
		return cozinhaRepository.findByNome(nome);
		}

		
		@GetMapping("/cozinhas/unica-por-nome")
		public Optional<Cozinha> listCozinhaUmaCozinha(String nome){
		return cozinhaRepository.findUnicaByNome(nome);
		}
}
