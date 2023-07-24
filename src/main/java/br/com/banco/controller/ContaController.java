package br.com.banco.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entity.Conta;
import br.com.banco.exception.WarningException;
import br.com.banco.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

	private ContaService contaService;
	
	public ContaController(ContaService contaService) {
		this.contaService = contaService;
	}
	
	@GetMapping
	public List<Conta> getAll() {
		return this.contaService.selectAll();
	}
	
	@GetMapping("/{numero}")
	public Conta getByNumero(@PathVariable Long numero) throws WarningException {
		return this.contaService.getContaById(numero);
	}
	
}
