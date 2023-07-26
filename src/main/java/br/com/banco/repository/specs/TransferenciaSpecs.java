package br.com.banco.repository.specs;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import br.com.banco.entity.Transferencia;

public class TransferenciaSpecs {

	public static Specification<Transferencia> contaNumeroEquals(Long contaNumero) {
		return (root, query, cb) -> cb.equal(root.get("conta").get("id"), contaNumero);
	}

	public static Specification<Transferencia> dataTransferenciaGreatEquals(Date dataTransferencia) {
		return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("dataTransferencia"), dataTransferencia);
	}
	
	public static Specification<Transferencia> dataTransferenciaLessEquals(Date dataTransferencia) {
		return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("dataTransferencia"), dataTransferencia);
	}
	
	public static Specification<Transferencia> operadorNomeEquals(String nomeOperadorTransacao) {
		return (root, query, cb) -> cb.equal(root.get("nomeOperadorTransacao"), nomeOperadorTransacao);
	}
}
