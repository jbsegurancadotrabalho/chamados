package br.com.jbst.entities;

import java.time.Instant;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Data
@Entity
@Table(name = "chamados")
public class Chamados {
	
	
	@Id
	@Column(name = "id")
	private UUID id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datahoracriacao", nullable = false)
	private Instant dataHoraCriacao;
	@Column(name = "nome_contato", length = 100, nullable = false)
	private String nome_contato;
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	@Column(name = "telefone", length = 100, nullable = false)
	private String telefone;
	@Column(name = "setor", length = 100, nullable = false)
	private String setor;
	@Column(name = "pessoa", length = 100, nullable = false)
	private String pessoa;
	@Column(name = "empresa", length = 100, nullable = false)
	private String empresa;
	@Column(name = "cnpj", length = 100, nullable = false)
	private String cnpj;
	@Column(name = "canal", length = 100, nullable = false)
	private String canal;
	
	@Column(name = "nome_atendente", length = 100, nullable = false)
	private String nome_atendente;
	
	@Column(name = "executante", length = 100, nullable = false)
	private String executante;
	@Column(name = "descreva_chamado", length = 500, nullable = false)
	private String descreva_chamado;
	@Column(name = "status_chamado", length = 100, nullable = false)
	private String status_chamado;
	@Column(name = "status_executante", length = 100, nullable = false)
	private String status_executante;

}
