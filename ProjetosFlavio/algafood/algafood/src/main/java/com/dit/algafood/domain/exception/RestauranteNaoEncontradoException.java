package com.dit.algafood.domain.exception;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {
//public class EntidadeNaoEncontradaException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;
	
	private static final String RESTAURANTE_NAO_ENCONTRADO 
	= "Não existe cadastro de restaurante com código %d";
	
	public RestauranteNaoEncontradoException (String mensagem) {
		super(mensagem);
	}
	
	public RestauranteNaoEncontradoException (Long cozinhaId) {
		this(String.format(RESTAURANTE_NAO_ENCONTRADO, cozinhaId));
	}
	

}
