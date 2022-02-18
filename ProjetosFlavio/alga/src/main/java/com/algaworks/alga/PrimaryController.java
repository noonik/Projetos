package com.algaworks.alga;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.alga.di.model.Cliente;
import com.algaworks.alga.di.service.AtivacaoClienteService;

@Controller
public class PrimaryController {
	
	private AtivacaoClienteService ativacaoClienteService;
	
	public PrimaryController(AtivacaoClienteService ativacaoClienteService) {
		this.ativacaoClienteService = ativacaoClienteService;
	}

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		
		Cliente joao = new Cliente("João", "joao@gmail.com", "11 965858910");
		ativacaoClienteService.ativar(joao);
		
		return "java 11! <version>2.4.0-M2</version> ";
		
	}

}
