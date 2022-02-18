package com.algaworks.alga.di.notificador;

import com.algaworks.alga.di.model.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String msg);

}