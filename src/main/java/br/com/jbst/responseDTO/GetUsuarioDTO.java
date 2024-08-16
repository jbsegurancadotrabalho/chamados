package br.com.jbst.responseDTO;

import java.util.UUID;

import lombok.Data;

@Data
public class GetUsuarioDTO {
	private UUID id;
	private String nome;
    private String email;

}
