package com.algaworks.alga.di.lista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.alga.di.notificador.NivelUrgencia;
import com.algaworks.alga.di.notificador.Notificador;
import com.algaworks.alga.di.notificador.TipoDoNotificador;
import com.algaworks.alga.di.service.ClienteAtivadoEvent;

@ Component
public class NotificacaoService {
	
	@TipoDoNotificador(NivelUrgencia.normal)
	@Autowired
	private Notificador notificador; 
	
	@EventListener
	public void clienteAtivoListado(ClienteAtivadoEvent event) {
		notificador.notificar(event.getCliente(), " Cadastro do cliente " + event.getCliente().getNome() + " agora está ativo no sitema" );
	}

}
