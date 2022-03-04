package com.dit.algafood.domain.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Embeddable
public class Endereco {
	
	@Column(name ="endereco_cep")
	private String cep;
	
	@Column(name ="endereco_logadouro")
	private String logadouro;
	
	@Column(name ="endereco_numero")
	private String numero;
	
	@Column(name ="endereco_complemento")
	private String complemento;
	
	@Column(name ="endereco_bairro")
	private String bairro;
	
	@JoinColumn(name ="endereco_cidade_id")
	@JsonIgnoreProperties("hibernateLazyInitializer")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cidade cidade;

}
