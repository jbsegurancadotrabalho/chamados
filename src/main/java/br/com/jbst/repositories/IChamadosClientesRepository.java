package br.com.jbst.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jbst.entities.ChamadosClientes;

public interface IChamadosClientesRepository extends JpaRepository<ChamadosClientes, UUID> {

}
