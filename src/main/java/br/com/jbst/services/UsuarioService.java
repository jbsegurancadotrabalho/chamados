package br.com.jbst.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbst.entities.Usuario;
import br.com.jbst.repositories.IUsuarioRepository;
import br.com.jbst.responseDTO.GetUsuarioDTO;

@Service
public class UsuarioService {
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	IUsuarioRepository usuarioRepository;

	public List<GetUsuarioDTO> buscarTodos() {
		List<Usuario> todosUsuarios = usuarioRepository.findAll();
		return todosUsuarios.stream().map(usuarios -> modelMapper.map(usuarios, GetUsuarioDTO.class))
				.collect(Collectors.toList());
	}
}
