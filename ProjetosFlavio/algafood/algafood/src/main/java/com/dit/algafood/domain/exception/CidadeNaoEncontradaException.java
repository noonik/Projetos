package com.dit.algafood.domain.exception;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {
//public class EntidadeNaoEncontradaException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;
	
	private static final String CIDADE_NAO_ENCONTRADA 
	= "Não existe cadastro de cidade com código %d";
	
	public CidadeNaoEncontradaException (String mensagem) {
		super(mensagem);
	}
	
	public CidadeNaoEncontradaException (Long estadoId) {
		this(String.format(CIDADE_NAO_ENCONTRADA, estadoId));
	}
	

}
