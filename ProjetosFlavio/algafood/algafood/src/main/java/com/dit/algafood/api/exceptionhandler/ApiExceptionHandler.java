package com.dit.algafood.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dit.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.dit.algafood.domain.exception.EntityEmUsoException;
import com.dit.algafood.domain.exception.NegocioException;


@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<?> TratarEntidadeException(
			EntidadeNaoEncontradaException e){
		
		Problema problema = Problema.builder()
				.dataHora(LocalDateTime.now())
				.mensagem(e.getMessage()).build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(problema);
	}
	
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> TratarNegocioException(
			NegocioException e){
		
		Problema problema = Problema.builder()
				.dataHora(LocalDateTime.now())
				.mensagem(e.getMessage()).build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(problema);
	}
	

	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<?> TratarMidiaTypeException(){
		
		Problema problema = Problema.builder()
				.dataHora(LocalDateTime.now())
				.mensagem("Tipo de mídia não suportado").build();
		
		return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
				.body(problema);
	}
	
	
	@ExceptionHandler(EntityEmUsoException.class)
	public ResponseEntity<?> tratarEntidadeEmUsoException(EntityEmUsoException e) {
	    Problema problema = Problema.builder()
	            .dataHora(LocalDateTime.now())
	            .mensagem(e.getMessage()).build();
	    
	    return ResponseEntity.status(HttpStatus.CONFLICT)
	            .body(problema);
	}
	

}
