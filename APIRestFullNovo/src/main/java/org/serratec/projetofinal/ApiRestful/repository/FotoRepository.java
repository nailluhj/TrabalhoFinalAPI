package org.serratec.projetofinal.ApiRestful.repository;

import java.util.Optional;

import org.serratec.projetofinal.ApiRestful.model.Foto;
import org.serratec.projetofinal.ApiRestful.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoRepository extends JpaRepository<Foto, Long>{

	public Optional<Foto> findByUsuario(Usuario usuario);
}
