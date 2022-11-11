package com.dit.algafood.domain.exception;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {
//public class EntidadeNaoEncontradaException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;
	
	private static final String ESTADO_NAO_ENCONTRADO 
	= "Não existe cadastro de estado com código %d";
	
	public EstadoNaoEncontradoException (String mensagem) {
		super(mensagem);
	}
	
	public EstadoNaoEncontradoException (Long estadoId) {
		this(String.format(ESTADO_NAO_ENCONTRADO, estadoId));
	}
	

}
