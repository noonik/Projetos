package com.dit.algafood.domain.exception;

public abstract class EntidadeNaoEncontradaException extends NegocioException {
//public class EntidadeNaoEncontradaException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontradaException (String mensagem) {
		super(mensagem);
	}

}
