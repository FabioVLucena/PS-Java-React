package br.com.banco.service;

import static br.com.banco.repository.specs.TransferenciaSpecs.contaNumeroEquals;
import static br.com.banco.repository.specs.TransferenciaSpecs.dataTransferenciaGreatEquals;
import static br.com.banco.repository.specs.TransferenciaSpecs.dataTransferenciaLessEquals;
import static br.com.banco.repository.specs.TransferenciaSpecs.operadorNomeEquals;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.banco.dto.TransferenciaRequestDTO;
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
	
	public List<Transferencia> findTransferencia(TransferenciaRequestDTO filtro) throws WarningException {
		Specification<Transferencia> specs = Specification.where((root, query, cb) -> cb.conjunction());
		
		if (filtro.getContaNumero() != null) {
			// validating if account exists
			this.contaService.getContaById(filtro.getContaNumero());
			
			specs = specs.and(contaNumeroEquals(filtro.getContaNumero()));
		}

		if (filtro.getDataTransferenciaInicial() != null) {
			specs = specs.and(dataTransferenciaGreatEquals(filtro.getDataTransferenciaInicial()));
		}
		
		if (filtro.getDataTransferenciaFinal() != null) {
			specs = specs.and(dataTransferenciaLessEquals(filtro.getDataTransferenciaFinal()));
		}
		
		if (filtro.getOperadorNome() != null) {
			specs = specs.and(operadorNomeEquals(filtro.getOperadorNome()));
		}
		
		return this.transferenciaRepository.findAll(specs);
	}
}
