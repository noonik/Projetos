package com.dit.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dit.algafood.AlgafoodApplication;
import com.dit.algafood.domain.entities.Cozinha;

public class AlteracaoCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		Cozinha p1 = new Cozinha();
		p1.setNome("Japoneja");
		
		Cozinha p2 = new Cozinha();
		p2.setNome("Holandeza");
		
		cadastroCozinha.salvar(p1);
		cadastroCozinha.salvar(p2);
		
	}
}


