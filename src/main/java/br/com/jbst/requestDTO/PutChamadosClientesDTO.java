package br.com.jbst.requestDTO;

import java.util.UUID;

import lombok.Data;

@Data
public class PutChamadosClientesDTO {
	private UUID id_chamados_clientes;
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
