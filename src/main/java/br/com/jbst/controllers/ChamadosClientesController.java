package br.com.jbst.controllers;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.jbst.requestDTO.PostChamadosClientesDTO;
import br.com.jbst.requestDTO.PutChamadosClientesDTO;
import br.com.jbst.responseDTO.GetChamadosClientesDTO;
import br.com.jbst.services.ChamadosClientesService;

@RestController
@RequestMapping("/api/chamados-clientes")
public class ChamadosClientesController {

    @Autowired
    private ChamadosClientesService chamadosClientesService;

    @PostMapping
    public ResponseEntity<GetChamadosClientesDTO> criarChamadosClientes(@RequestBody PostChamadosClientesDTO dto) throws Exception {
        GetChamadosClientesDTO response = chamadosClientesService.criarChamadosClientes(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetChamadosClientesDTO> editarChamadosClientes(
            @PathVariable UUID id,
            @RequestBody PutChamadosClientesDTO dto) {
        
        dto.setId_chamados_clientes(id);
        GetChamadosClientesDTO response = chamadosClientesService.editarChamadosClientes(dto);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetChamadosClientesDTO> buscarPorId(@PathVariable UUID id) {
        GetChamadosClientesDTO response = chamadosClientesService.buscarPorId(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<GetChamadosClientesDTO>> buscarTodos() {
        List<GetChamadosClientesDTO> response = chamadosClientesService.buscarTodos();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirChamadosClientes(@PathVariable UUID id) {
        try {
            chamadosClientesService.excluirChamadosClientes(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
