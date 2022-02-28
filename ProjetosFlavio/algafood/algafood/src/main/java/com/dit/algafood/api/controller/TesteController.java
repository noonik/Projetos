package com.dit.algafood.api.controller;

import java.util.List;

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
	
	/* End-Point de teste
		@GetMapping("/cozinhas/por-nome")
		public List<Cozinha> listCozinhasPorNome(@RequestParam("nome") String nome){
		return cozinhaRepository.listarPorNome(nome);
		}*/

}
