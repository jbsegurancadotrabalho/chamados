package br.com.jbst.responseDTO;


import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.jbst.config.InstantSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ChamadosResponseGet {
	
	
	private UUID id;
	@JsonSerialize(using = InstantSerializer.class)
	private Instant dataHoraCriacao;
	private String nome_contato;
	private String email;
	private String telefone;
	private String setor;
	private String pessoa;
	private String empresa;
	private String cnpj;
	private String canal;
	private String nome_atendente;
	private String executante;
	private String descreva_chamado;
	private String status_chamado;
	private String status_executante;

}
