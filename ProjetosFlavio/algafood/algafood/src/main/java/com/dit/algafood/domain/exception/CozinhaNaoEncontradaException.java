package com.dit.algafood.domain.exception;

public class CozinhaNaoEncontradaException extends EntidadeNaoEncontradaException {
//public class EntidadeNaoEncontradaException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;
	
	private static final String COZINHA_NAO_ENCONTRADA 
	= "Não existe cadastro de cozinha com código %d";
	
	public CozinhaNaoEncontradaException (String mensagem) {
		super(mensagem);
	}
	
	public CozinhaNaoEncontradaException (Long cozinhaId) {
		this(String.format(COZINHA_NAO_ENCONTRADA, cozinhaId));
	}
	

}
