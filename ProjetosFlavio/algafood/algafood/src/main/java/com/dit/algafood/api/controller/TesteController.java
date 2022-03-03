package com.dit.algafood.api.controller;

import static com.dit.algafood.infrainstructure.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.dit.algafood.infrainstructure.repository.spec.RestauranteSpecs.comNomeSemelhante;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dit.algafood.domain.entities.Cozinha;
import com.dit.algafood.domain.entities.Restaurante;
import com.dit.algafood.domain.repository.CozinhaRepository;
import com.dit.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
		@GetMapping("/cozinhas/por-nome")
		public List<Cozinha> listCozinhasPorNome(String nome){
		return cozinhaRepository.findByNomeContaining(nome);
		}

		
		@GetMapping("/cozinhas/unica-por-nome")
		public Optional<Cozinha> listRestaurantePorTaxaFrete(String nome){
		return cozinhaRepository.findUnicaByNome(nome);
		}
		
		@GetMapping("/cozinhas/exists")
		public boolean cozinhaExists(String nome){
		return cozinhaRepository.existsByNome(nome);
		}
		
		
		@GetMapping("/restaurantes/por-taxa-frete")
		public List<Restaurante> listRestaurantePorTaxaFrete(BigDecimal taxaInicio, BigDecimal taxaFim){
		return restauranteRepository.findByTaxaFreteBetween(taxaInicio, taxaFim);
		}
		
		@GetMapping("/restaurantes/por-nome")
		public List<Restaurante> listRestaurantePorNome(String nome, Long cozinhaId){
		return restauranteRepository.consultarPorNome(nome, cozinhaId);
		}
		
		@GetMapping("/restaurantes/por-nome-e-frete")
		public List<Restaurante> restaurantePorNomeFrete(String nome,
				BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
		return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
		}
		
		@GetMapping("/restaurantes/primeiro-por-nome")
		public Optional<Restaurante> listRestaurantePorNome(String nome){
		return restauranteRepository.findFirstByNomeContaining(nome);
		}
		
		@GetMapping("/restaurantes/top2-por-nome")
		public List<Restaurante> top2RestaurantePorNome(String nome){
		return restauranteRepository.findTop2ByNomeContaining(nome);
		}
		
		@GetMapping("/restaurantes/com-frete-gratis")
		public List<Restaurante> restaurantesComFreteGratis(String nome){
		return restauranteRepository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
		}
		
		@GetMapping("/restaurantes/count-por-cozinha")
		public int restauranteCountPorCozinha(Long id){
		return restauranteRepository.countByCozinhaId(id);
		}
		
		//findByTaxaFreteBetween
}
