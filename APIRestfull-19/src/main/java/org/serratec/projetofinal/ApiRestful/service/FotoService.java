package org.serratec.projetofinal.ApiRestful.service;

import java.io.IOException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.projetofinal.ApiRestful.model.Foto;
import org.serratec.projetofinal.ApiRestful.model.Relacionamento;
import org.serratec.projetofinal.ApiRestful.model.Usuario;
import org.serratec.projetofinal.ApiRestful.repository.FotoRepository;
import org.serratec.projetofinal.ApiRestful.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoService {

	@Autowired
	private FotoRepository fotoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public String inserir(Relacionamento relacionamento, MultipartFile file) {
		return null;
	}
	
	public Foto inserir(Usuario usuario, MultipartFile file) throws IOException {
		Foto foto = new Foto();
		foto.setNome(file.getName());
		foto.setTipo(file.getContentType());
		foto.setDados(file.getBytes());
		foto.setUsuario(usuario);
		
		foto = fotoRepository.save(foto);
		
		return foto;
	}
	
	@Transactional
	public Foto buscarPorIdUsuario(Long id) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		if (usuarioOpt.isEmpty()) {
			return null;
		}
		
		Optional<Foto> fotoOpt = fotoRepository.findByUsuario(usuarioOpt.get());
		if (fotoOpt.isEmpty()) {
			return null;
		}
		
		return fotoOpt.get();
	}

}
