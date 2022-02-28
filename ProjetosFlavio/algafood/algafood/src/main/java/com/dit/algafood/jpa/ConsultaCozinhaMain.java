package com.dit.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dit.algafood.AlgafoodApplication;
import com.dit.algafood.domain.entities.Cozinha;
import com.dit.algafood.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		List<Cozinha> cozinhas = cozinhaRepository.findAll();
		
		for (Cozinha cozinha : cozinhas ) {
			System.out.println(cozinha.getNome());
		}
		
		
	}
}


