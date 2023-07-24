package br.com.banco.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.banco.dto.ApiErrorResponseDTO;
import br.com.banco.exception.WarningException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorResponseDTO treatmentMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		List<String> errorStrList = ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(errorStr -> errorStr.getDefaultMessage())
				.collect(Collectors.toList());
		
		return new ApiErrorResponseDTO(errorStrList);
	}
	
	@ExceptionHandler(WarningException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorResponseDTO treatmentWarningException(WarningException ex) {
		String errorStr = ex.getMessage();
		
		return new ApiErrorResponseDTO(errorStr);
	}
	
}
