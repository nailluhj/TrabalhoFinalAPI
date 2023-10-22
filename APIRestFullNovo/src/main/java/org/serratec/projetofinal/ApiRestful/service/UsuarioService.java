package org.serratec.projetofinal.ApiRestful.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.projetofinal.ApiRestful.DTO.UsuarioDTO;
import org.serratec.projetofinal.ApiRestful.exception.EmailException;
import org.serratec.projetofinal.ApiRestful.model.Usuario;
import org.serratec.projetofinal.ApiRestful.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private FotoService fotoService;
	
	public List<UsuarioDTO> listar() {
		List<Usuario> usuarioList = usuarioRepository.findAll();
		
		List<UsuarioDTO> usuarioDtoList = usuarioList.stream().map(u -> {
			return adicionarImagemURI(u);
		}).collect(Collectors.toList());
		
		return usuarioDtoList;
	}
	
	public UsuarioDTO adicionarImagemURI(Usuario usuario) {
		URI uri = ServletUriComponentsBuilder.
				fromCurrentContextPath()
				.path("/usuario/{id}/foto")
				.buildAndExpand(usuario.getId())
				.toUri();
		
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNome(usuario.getNome());
		dto.setSobrenome(usuario.getSobrenome());
		dto.setDataNascimento(usuario.getDataNascimento());
		dto.setEmail(usuario.getEmail());
		dto.setUrlImagem(uri.toString());
		return dto;
	}
		
//<<<<<<< HEAD
//=======
//
//>>>>>>> branch 'main' of https://github.com/janaelson/APIRestfull.git
	
	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		/*
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		for (Usuario usuario: usuarios) {
			usuariosDTO.add(new UsuarioDTO(usuario));
		}
		*/
		List<UsuarioDTO> usuariosDTO = usuarios.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());
		return usuariosDTO;
	}
	
	   public UsuarioDTO findById(Long id) {
	        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
	        if (usuarioOpt.isPresent()) {
	        	UsuarioDTO usuarioDTO = new UsuarioDTO(usuarioOpt.get());
	            return usuarioDTO;
	        }
	        return null;
	    }
	   
	   public Optional<Usuario> findUsuarioById(Long id) {
	        return usuarioRepository.findById(id);
	    }
	    
	public UsuarioDTO inserir(Usuario usuario) throws EmailException {
		Usuario usuarioEmailExistente = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioEmailExistente != null) {
			throw new EmailException("Email já cadastrado.");
		}
		
		usuario = usuarioRepository.save(usuario);
		UsuarioDTO usuarioDto = new UsuarioDTO(usuario);
		return usuarioDto;
	}
	
	
	public UsuarioDTO inserirComFoto(Usuario usuario, MultipartFile file) throws EmailException, IOException {
		 Usuario usuarioEmailExistente = usuarioRepository.findByEmail(usuario.getEmail());
		 if (usuarioEmailExistente != null) {
	            throw new EmailException("Email já cadastrado.");
	        }
		 
		 usuario = usuarioRepository.save(usuario);
	        fotoService.inserir(usuario, file);
	        return adicionarImagemURI(usuario);
	    }
	}


//<<<<<<< HEAD
//=======
////		RelacionamentoDTO relacionamentoDTO = new RelacionamentoDTO(); 
//		Usuario usuarios = usuario;
//		usuarios.setNome(usuariosDTO.getNome());
//		usuarios.setSenha(usuariosDTO.getSobrenome());
//		usuarios.setEmail(usuariosDTO.getEmail());
//		usuarios.setDataNascimento(usuariosDTO.getDataNascimento());
////		usuario.setRelacionamento(relacionamentoDTO.getClass());
//>>>>>>> branch 'main' of https://github.com/janaelson/APIRestfull.git
		
//		usuario = usuarioRepository.save(usuario);
//		if(!usuario.getRelacionamento().isEmpty()) {
//			for(Relacionamento rela: usuario.getRelacionamento()) {
//				Optional<Usuario> findById = usuarioRepository.findById(rela.getId().getUsuarioseguido().getId());
//				rela.getId().setUsuarioseguido(findById.get());
//				rela.getId().setUsuario(usuario);
//			}
//		}
	
	


