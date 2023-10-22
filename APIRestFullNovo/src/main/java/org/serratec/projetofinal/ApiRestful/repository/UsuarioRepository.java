package org.serratec.projetofinal.ApiRestful.repository;

import org.serratec.projetofinal.ApiRestful.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);

}
