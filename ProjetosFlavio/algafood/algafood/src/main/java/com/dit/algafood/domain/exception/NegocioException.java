package com.dit.algafood.domain.exception;

public class NegocioException extends RuntimeException {
//public class EntidadeNaoEncontradaException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;
	
	public NegocioException (String mensagem) {
		super(mensagem);
	}
	
	public NegocioException (String mensagem, Throwable causa ) {
		super(mensagem, causa);
	}

}
