package br.com.jbst.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbst.entities.ChamadosClientes;
import br.com.jbst.entities.Usuario;
import br.com.jbst.repositories.IChamadosClientesRepository;
import br.com.jbst.repositories.IUsuarioRepository;
import br.com.jbst.requestDTO.PostChamadosClientesDTO;
import br.com.jbst.requestDTO.PutChamadosClientesDTO;
import br.com.jbst.responseDTO.GetChamadosClientesDTO;

@Service
public class ChamadosClientesService {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	IUsuarioRepository usuarioRepository;

	@Autowired
	IChamadosClientesRepository chamadosClientesRepository;
	
	public GetChamadosClientesDTO criarChamadosClientes(PostChamadosClientesDTO dto) throws Exception {
		ChamadosClientes chamados = modelMapper.map(dto, ChamadosClientes.class);
		chamados.setDataHoraCriacao(Instant.now());
	    
        Usuario usuario = usuarioRepository.findById(dto.getId()).orElseThrow(() -> new Exception("Usuário não encontrado"));
        chamados.setUsuario(usuario);
        
		chamados.setId_chamados_clientes(UUID.randomUUID());
		chamados = chamadosClientesRepository.save(chamados);
		return modelMapper.map(chamados, GetChamadosClientesDTO.class);
	}
	
	public GetChamadosClientesDTO editarChamadosClientes(PutChamadosClientesDTO dto) {
	     // Verifica se o ID do dano é válido
        UUID Id_chamados_cliente = dto.getId_chamados_clientes();
        if (Id_chamados_cliente == null) {
            return null;
        }

	        // Busca o dano no banco de dados com base no ID fornecido
		ChamadosClientes chamadosExistente = chamadosClientesRepository.findById(Id_chamados_cliente).orElse(null);

	        // Se o dano não for encontrado, retorna null
	        if (chamadosExistente == null) {
	            return null;
	        }

	        // Atualiza os dados do dano existente com base nas informações fornecidas no DTO
	        modelMapper.map(dto, chamadosExistente);

	        // Define a data e hora de criação como a data e hora atuais
	        chamadosExistente.setDataHoraCriacao(Instant.now());

	        // Salva o dano atualizado no banco de dados
	        ChamadosClientes danosAtualizado = chamadosClientesRepository.save(chamadosExistente);

	        // Retorna o dano atualizado convertido para DTO
	        return modelMapper.map(danosAtualizado, GetChamadosClientesDTO.class);
	    }
	
	public GetChamadosClientesDTO buscarPorId(UUID Id_chamados_clientes) {
		ChamadosClientes danos = chamadosClientesRepository.findById(Id_chamados_clientes).orElse(null);
	        return danos != null ? modelMapper.map(danos, GetChamadosClientesDTO.class) : null;
	    }

	    public List< GetChamadosClientesDTO> buscarTodos() {
	        List<ChamadosClientes> todosChamados = chamadosClientesRepository.findAll();
	        return todosChamados.stream()
	            .map(chamados -> modelMapper.map(chamados, GetChamadosClientesDTO.class))
	            .collect(Collectors.toList());
	    }
	    
		public void excluirChamadosClientes(UUID id) throws Exception {
			Optional<ChamadosClientes> ChamadosClientesOptional = chamadosClientesRepository.findById(id);
			if (ChamadosClientesOptional.isPresent()) {
				chamadosClientesRepository.deleteById(id);
			} else {
				throw new Exception("Chamados não encontrado com o ID: " + id);
			}
		}
}
