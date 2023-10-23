package org.serratec.projetofinal.ApiRestful.repository;

import java.util.List;

import org.serratec.projetofinal.ApiRestful.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
	List<Comentario> findByPostagemId(Long postagemId);
}
