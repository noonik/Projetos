package com.dit.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dit.algafood.AlgafoodApplication;
import com.dit.algafood.domain.entities.Restaurante;
import com.dit.algafood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		List<Restaurante> restaurantes = restauranteRepository.findAll();
		
		for (Restaurante restaurante : restaurantes ) {
			System.out.printf("%s - %f - %s - %s \n", restaurante.getNome(),
					restaurante.getTaxaFrete(), restaurante.getCozinha().getNome(), restaurante.getFormasPagamento());
		}
		
		
	}
}


