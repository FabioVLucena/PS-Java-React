package br.com.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.banco.entity.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>, JpaSpecificationExecutor<Transferencia> {
	
	@Query("from transferencia where conta_id = :contaId")
	List<Transferencia> findByContaId(@Param("contaId") Long contaId);
}
