package br.com.banco.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "transferencia")
public class Transferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "data_transferencia", nullable = false)
	private Date dataTransferencia;
	
	@Column(name = "valor", length = 20, precision = 2, nullable = false)
	private BigDecimal valor;
	
	@Column(name = "tipo", length = 15, nullable = false)
	private String tipo;
	
	@Column(name = "nome_operador_transacao", length = 50)
	private String nomeOperadorTransacao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_id", referencedColumnName = "id")
	private Conta conta;

}
