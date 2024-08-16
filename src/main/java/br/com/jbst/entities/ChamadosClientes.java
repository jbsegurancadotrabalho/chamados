package br.com.jbst.entities;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "chamados_clientes")
public class ChamadosClientes {

	@Id
	@Column(name = "id_chamados_clientes")
	private UUID id_chamados_clientes;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datahoracriacao", nullable = false)
	private Instant dataHoraCriacao;

	@Column(name = "nome_contato", length = 100, nullable = false)
	private String nome_contato;

	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "telefone", length = 100, nullable = false)
	private String telefone;

	@Column(name = "empresa", length = 100, nullable = false)
	private String empresa;

	@Column(name = "cnpj", length = 100, nullable = false)
	private String cnpj;

	@Column(name = "tipo_servico", length = 100, nullable = false)
	private String tipo_servico;

	@Column(name = "corpo_assunto", length = 500, nullable = false)
	private String corpo_assunto;

	@Column(name = "status_chamado", length = 100, nullable = true)
	private String status_chamado;
	
	
	@Column(name = "resposta_chamado", length = 1500, nullable = true)
	private String resposta_chamado;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Usuario usuario;
}
