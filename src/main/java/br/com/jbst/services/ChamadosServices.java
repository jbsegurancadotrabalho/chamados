package br.com.jbst.services;


import java.time.Instant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbst.entities.Chamados;
import br.com.jbst.repositories.ChamadosRepository;
import br.com.jbst.requestDTO.ChamadosRequestPost;
import br.com.jbst.requestDTO.ChamadosRequestPut;
import br.com.jbst.responseDTO.ChamadosResponseGet;
import br.com.jbst.responseDTO.ChamadosResponsePost;

@Service
public class ChamadosServices {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	ChamadosRepository chamadosRepository;

	public ChamadosResponsePost create(ChamadosRequestPost dto) throws Exception {

		try {
			
			Chamados chamado = modelMapper.map(dto, Chamados.class);
			chamado.setId(UUID.randomUUID());
			chamado.setDataHoraCriacao(Instant.now());
			chamadosRepository.save(chamado);
		return modelMapper.map(chamadosRepository.find(chamado.getId()), ChamadosResponsePost.class);
		
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
public ChamadosResponseGet update(ChamadosRequestPut dto) throws Exception {
		
		//verificando se o produto existe (baseado no ID informado)
		Optional<Chamados> chamado = chamadosRepository.findById(dto.getId());
		if(chamado.isEmpty())
			throw new IllegalArgumentException("Chamado inválido: " + dto.getId());		
		
		//capturando o produto do banco de dados
		Chamados chamados = chamado.get();
		chamados = modelMapper.map(dto, Chamados.class);
		chamados.setDataHoraCriacao(Instant.now());
		chamadosRepository.save(chamados);
		
		//copiar os dados do produto para o DTO de resposta
		//e retornar os dados (ProdutosGetDTO)
		return modelMapper.map(chamadosRepository.find
				(chamados.getId()), ChamadosResponseGet.class);
	}
	
	
	
	public ChamadosResponseGet delete(UUID id) throws Exception {

		// verificando se o produto existe (baseado no ID informado)
		Optional<Chamados> chamado = chamadosRepository.findById(id);
		if (chamado.isEmpty())
			throw new IllegalArgumentException("Chamado inválido: " + id);

		// capturando o produto do banco de dados
		Chamados chamados = chamado.get();

		// excluindo o produto no banco de dados
		chamadosRepository.delete(chamados);

		// copiar os dados do produto para o DTO de resposta
		// e retornar os dados (ProdutosGetDTO)
		return modelMapper.map(chamados, ChamadosResponseGet.class);
	}

	public List<ChamadosResponseGet> getAll() throws Exception {

		List<Chamados> chamados = chamadosRepository.findAll();
		List<ChamadosResponseGet> lista = modelMapper.map(chamados, new TypeToken<List<ChamadosResponseGet>>() {
		}.getType());
		return lista;
	}
	
	public List<ChamadosResponseGet> chamadosPorMesAno(int mes, int ano) throws Exception {

		List<Chamados> chamados = chamadosRepository.findChamadosByMesAndAno(mes, ano);
		List<ChamadosResponseGet> lista = modelMapper.map(chamados, new TypeToken<List<ChamadosResponseGet>>() {
		}.getType());
		return lista;
	}


	public ChamadosResponseGet getById(UUID id) throws Exception {

		// consultando o produto através do ID
		Chamados chamados = chamadosRepository.find(id );
		if (chamados == null)
			throw new IllegalArgumentException("Chamados não encontrado: " + id);

		// retornando os dados
		return modelMapper.map(chamados, ChamadosResponseGet.class);
	}

}
