package br.com.banco.service;

import org.springframework.stereotype.Service;

import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	private TransferenciaRepository transferenciaRepository;	
	
	public TransferenciaService(TransferenciaRepository transferenciaRepository) {
		this.transferenciaRepository = transferenciaRepository;
	}
	
}
