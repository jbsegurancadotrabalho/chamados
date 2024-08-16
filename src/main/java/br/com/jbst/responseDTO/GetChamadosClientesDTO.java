package br.com.jbst.responseDTO;

import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.jbst.config.InstantSerializer;
import lombok.Data;


@Data
public class GetChamadosClientesDTO {
	private UUID id_chamados_clientes;
	@JsonSerialize(using = InstantSerializer.class)
	private Instant dataHoraCriacao;
	private String nome_contato;
	private String email;
	private String telefone;
	private String empresa;
	private String cnpj;
	private String tipo_servico;
	private String corpo_assunto;
	private String status_chamado;
	private String resposta_chamado;
}
