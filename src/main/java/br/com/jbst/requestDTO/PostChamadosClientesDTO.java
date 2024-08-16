package br.com.jbst.requestDTO;

import java.util.UUID;

import lombok.Data;

@Data
public class PostChamadosClientesDTO {
	private String nome_contato;
	private String email;
	private String telefone;
	private String empresa;
	private String cnpj;
	private String tipo_servico;
	private String corpo_assunto;
	private UUID id;

	}
