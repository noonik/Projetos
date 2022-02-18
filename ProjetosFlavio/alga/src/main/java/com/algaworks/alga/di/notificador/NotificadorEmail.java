package com.algaworks.alga.di.notificador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.alga.di.model.Cliente;

@TipoDoNotificador(NivelUrgencia.normal)
@Component
public class NotificadorEmail implements Notificador {
		
	@Autowired
	private NotificadorProperties properties;
		
	@Override
	public void notificar(Cliente cliente, String msg) {
		System.out.println("host: " + properties.getHostServidor());
		System.out.println("Porta: " + properties.getPortaServidor());
		
		System.out.printf("Notificação %s por e-mail %s:  %s\n", 
				cliente.getNome(), cliente.getEmail(), msg);
	}

}