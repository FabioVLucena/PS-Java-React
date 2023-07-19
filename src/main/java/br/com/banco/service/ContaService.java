package br.com.banco.service;

import org.springframework.stereotype.Service;

import br.com.banco.repository.ContaRepository;

@Service
public class ContaService {

	private ContaRepository contaRepository;

	public ContaService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}
	
}
