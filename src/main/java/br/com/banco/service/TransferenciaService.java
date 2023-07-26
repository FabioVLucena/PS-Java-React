package br.com.banco.service;

import static br.com.banco.repository.specs.TransferenciaSpecs.contaNumeroEquals;
import static br.com.banco.repository.specs.TransferenciaSpecs.dataTransferenciaGreatEquals;
import static br.com.banco.repository.specs.TransferenciaSpecs.dataTransferenciaLessEquals;
import static br.com.banco.repository.specs.TransferenciaSpecs.operadorNomeEquals;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.banco.dto.TransferenciaFilterRequestDTO;
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
	
	public List<Transferencia> findTransferencia(TransferenciaFilterRequestDTO filter) throws WarningException {
		Specification<Transferencia> specs = Specification.where((root, query, cb) -> cb.conjunction());
		
		if (filter.getContaNumero() != null) {
			// validating if account exists
			this.contaService.getContaById(filter.getContaNumero());
			
			specs = specs.and(contaNumeroEquals(filter.getContaNumero()));
		}

		if (filter.getDataTransferenciaInicial() != null) {
			specs = specs.and(dataTransferenciaGreatEquals(filter.getDataTransferenciaInicial()));
		}
		
		if (filter.getDataTransferenciaFinal() != null) {
			specs = specs.and(dataTransferenciaLessEquals(filter.getDataTransferenciaFinal()));
		}
		
		if (filter.getOperadorNome() != null) {
			specs = specs.and(operadorNomeEquals(filter.getOperadorNome()));
		}
		
		return this.transferenciaRepository.findAll(specs);
	}
}
