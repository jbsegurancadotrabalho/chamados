package br.com.jbst.repositories;


import java.util.List;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jbst.entities.Chamados;


public interface ChamadosRepository extends JpaRepository<Chamados, UUID>  {
	
	
	@Query("select c from Chamados c where c.id = :id ")
	Chamados find(@Param("id") UUID id);
	
	   @Query("SELECT c FROM Chamados c WHERE EXTRACT(MONTH FROM c.dataHoraCriacao) = :mes AND EXTRACT(YEAR FROM c.dataHoraCriacao) = :ano")
	    List<Chamados> findChamadosByMesAndAno(@Param("mes") int mes, @Param("ano") int ano);

}


