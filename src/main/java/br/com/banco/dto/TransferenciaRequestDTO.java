package br.com.banco.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TransferenciaRequestDTO {

	@NotNull(message = "Numero é um campo obrigatório.")
	@NotEmpty(message = "Numero não pode ser vazio.")
	@NotBlank(message = "Numero não pode ser vazio.")
	private Long numero;
	
}
