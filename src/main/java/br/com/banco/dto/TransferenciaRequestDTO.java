package br.com.banco.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class TransferenciaRequestDTO {

	@NotNull(message = "Numero da conta é um campo obrigatório.")
	@NotEmpty(message = "Numero da conta não pode ser vazio.")
	@NotBlank(message = "Numero da conta não pode ser vazio.")
	private Long contaNumero;
	
}
