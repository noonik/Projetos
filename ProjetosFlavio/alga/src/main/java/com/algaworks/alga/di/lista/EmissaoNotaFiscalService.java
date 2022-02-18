package com.algaworks.alga.di.lista;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.alga.di.service.ClienteAtivadoEvent;

@Component
public class EmissaoNotaFiscalService {
	
	@EventListener
	public void clienteAtivoListado(ClienteAtivadoEvent event) {
		System.out.println("Emitindo nota fiscal para o cliente " + event.getCliente().getNome());
	}
}
