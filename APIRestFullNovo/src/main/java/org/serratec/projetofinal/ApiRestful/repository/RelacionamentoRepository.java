package org.serratec.projetofinal.ApiRestful.repository;

import java.util.List;

import org.serratec.projetofinal.ApiRestful.model.Relacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RelacionamentoRepository extends JpaRepository<Relacionamento, Long>{
	
	@Query("SELECT r FROM Relacionamento r WHERE r.id.usuario.id = :idusuario")
	public List<Relacionamento> buscarRelacionamentos(@Param("idusuario") Long idusuario );
}
