package br.com.banco.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.banco.entity.Transferencia;
import br.com.banco.exception.WarningException;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	private ContaService contaService;	
	private TransferenciaRepository transferenciaRepository;	
	
	public TransferenciaService(ContaService contaService, TransferenciaRepository transferenciaRepository) {
		this.contaService = contaService;
		this.transferenciaRepository = transferenciaRepository;
	}
	
	public List<Transferencia> findTransferencia(Long contaNumero, 
			Date dataTransferenciaInicial, 
			Date dataTransferenciaFinal, 
			String operadorNome) throws WarningException {
		
		// validating if account exists
		this.contaService.getContaById(contaNumero);
		
		if (contaNumero != null) {
			return this.transferenciaRepository.findByContaId(contaNumero);
		}
		
		throw new WarningException("Nenhuma transferência localizada!");
	}
	
}
