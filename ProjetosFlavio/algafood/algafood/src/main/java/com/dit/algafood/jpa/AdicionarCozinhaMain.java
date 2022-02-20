package com.dit.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dit.algafood.AlgafoodApplication;
import com.dit.algafood.domain.entities.Cozinha;
import com.dit.algafood.domain.repository.CozinhaRepository;

public class AdicionarCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha p1 = new Cozinha();
		p1.setNome("Italiana");
		p1.setId(1L);
		
		cozinhaRepository.salvar(p1);
		
		
	}
}


