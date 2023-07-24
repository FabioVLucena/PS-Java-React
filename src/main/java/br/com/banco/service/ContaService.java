package br.com.banco.service;

import org.springframework.stereotype.Service;

import br.com.banco.entity.Conta;
import br.com.banco.exception.WarningException;
import br.com.banco.repository.ContaRepository;

@Service
public class ContaService {

	private ContaRepository contaRepository;

	public ContaService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}
	
	public Conta getContaById(Long contaId) throws WarningException {
		Conta conta = this.contaRepository
				.findById(contaId)
				.orElseThrow(() -> new WarningException("A conta não foi localizada!"));
		
		return conta;
	}
	
}
