package org.serratec.projetofinal.ApiRestful.repository;

import org.serratec.projetofinal.ApiRestful.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

}
