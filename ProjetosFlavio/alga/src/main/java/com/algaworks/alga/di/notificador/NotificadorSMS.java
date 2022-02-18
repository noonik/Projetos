package com.algaworks.alga.di.notificador;

import org.springframework.stereotype.Component;

import com.algaworks.alga.di.model.Cliente;

@TipoDoNotificador(NivelUrgencia.urgente)
@Component
public class NotificadorSMS implements Notificador  {
	
	@Override
	public void notificar(Cliente cliente, String msg ) {
		System.out.printf("Notificação %s por SMS pelo telefone %s:  %s\n", 
				cliente.getNome(), cliente.getTelefone(), msg);
	}
	
}
