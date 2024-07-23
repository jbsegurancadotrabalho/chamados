package br.com.jbst.controllers;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbst.requestDTO.ChamadosRequestPost;
import br.com.jbst.requestDTO.ChamadosRequestPut;
import br.com.jbst.responseDTO.ChamadosResponseGet;
import br.com.jbst.responseDTO.ChamadosResponsePost;
import br.com.jbst.services.ChamadosServices;

@RestController
@RequestMapping(value = "/api/chamados")
public class ChamadosController {

	@Autowired
	ChamadosServices chamadosServices;

	@PostMapping
	public ResponseEntity<ChamadosResponsePost> CriarChamado(@RequestBody ChamadosRequestPost dto) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(chamadosServices.create(dto));

	}

	@PutMapping
	public ResponseEntity<ChamadosResponseGet> EditarChamado(@RequestBody ChamadosRequestPut dto) throws Exception {

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(chamadosServices.update(dto));
	}

	@GetMapping("{id}")
	public ResponseEntity<ChamadosResponseGet> ConsultarChamado(@PathVariable("id") UUID id) throws Exception {

		return ResponseEntity.status(HttpStatus.OK).body(chamadosServices.getById(id));

	}

	@GetMapping
	public ResponseEntity<List<ChamadosResponseGet>> get() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(chamadosServices.getAll());

	}

	@DeleteMapping("{id}")
	public ResponseEntity<ChamadosResponseGet> ExcluirChamado(@PathVariable("id") UUID id ) throws Exception {

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(chamadosServices.delete(id));
	}
	
	@GetMapping("/chamados-por-mes-e-ano")
    public ResponseEntity<List<ChamadosResponseGet>> getChamadosPorMesAno(@RequestParam("mes") int mes, @RequestParam("ano") int ano) {
        try {
            List<ChamadosResponseGet> chamados = chamadosServices.chamadosPorMesAno(mes, ano);
            return ResponseEntity.ok(chamados);
        } catch (Exception e) {
            // Lida com exceções, retorna um erro 500 com uma mensagem de erro adequada
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
