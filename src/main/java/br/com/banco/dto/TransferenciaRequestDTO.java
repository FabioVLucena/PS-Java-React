package br.com.banco.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class TransferenciaRequestDTO {

	@NotEmpty(message = "Numero da conta não pode ser vazio.")
	@NotBlank(message = "Numero da conta não pode ser vazio.")
	private Long contaNumero;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataTransferenciaInicial;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataTransferenciaFinal;

	@NotEmpty(message = "Nome do operador não pode ser vazio.")
	@NotBlank(message = "Nome do operador não pode ser vazio.")
	private String operadorNome;
	
}
