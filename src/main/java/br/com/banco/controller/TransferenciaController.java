package br.com.banco.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.TransferenciaRequestDTO;
import br.com.banco.entity.Transferencia;
import br.com.banco.exception.WarningException;
import br.com.banco.service.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

	private TransferenciaService transferenciaService;
	
	public TransferenciaController(TransferenciaService transferenciaService) {
		this.transferenciaService = transferenciaService;
	}
	
	@PostMapping
	public List<Transferencia> findTransferencia(@RequestBody TransferenciaRequestDTO filtro) throws WarningException {
		List<Transferencia> transferenciaList = this.transferenciaService.findTransferencia(filtro);
		
		return transferenciaList;
	}
	
}
