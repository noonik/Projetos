package com.algaworks.alga.di.service;

import com.algaworks.alga.di.model.Cliente;

public class ClienteAtivadoEvent {

	private Cliente cliente;

	public ClienteAtivadoEvent(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
}
