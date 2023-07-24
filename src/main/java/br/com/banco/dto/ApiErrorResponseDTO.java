package br.com.banco.dto;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErrorResponseDTO {

	@Getter
	private List<String> error;
	
	public ApiErrorResponseDTO(List<String> apiErrorList) {
		this.error = apiErrorList;
	}
	
	public ApiErrorResponseDTO(String errorMessage) {
		this.error = Arrays.asList(errorMessage);
	}
	
}
