package org.serratec.projetofinal.ApiRestful.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.xml.crypto.Data;

import org.serratec.projetofinal.ApiRestful.model.Comentario;
import org.serratec.projetofinal.ApiRestful.model.Postagem;
import org.serratec.projetofinal.ApiRestful.DTO.ComentarioDTO;
import org.serratec.projetofinal.ApiRestful.repository.ComentarioRepository;
import org.serratec.projetofinal.ApiRestful.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;

	@Autowired
	private PostagemRepository postagemRepository;

	public List<ComentarioDTO> listarComentariosPorPostagem(Long postagemId) {
		List<Comentario> comentarios = comentarioRepository.findByPostagemId(postagemId);
		return comentarios.stream().map(this::comentarioParaComentarioDTO).collect(Collectors.toList());
	}

	public ComentarioDTO buscarComentarioPorId(Long id) {
		Optional<Comentario> comentarioOpt = comentarioRepository.findById(id);
		return comentarioOpt.map(this::comentarioParaComentarioDTO).orElse(null);
	}

	public ComentarioDTO inserirComentario(ComentarioDTO comentarioDTO) {
		Comentario comentario = new Comentario();
		if (comentarioDTO.getIdPostagem() != null) {
			Optional<Postagem> postagemOpt = postagemRepository.findById(comentarioDTO.getIdPostagem());

			if (postagemOpt.isPresent()) {
				comentario.setPostagem(postagemOpt.get());
				comentario.setTexto(comentarioDTO.getTexto());
				comentario.setDataCriacao(comentarioDTO.getData());
				comentario = comentarioRepository.save(comentario);
				return comentarioParaComentarioDTO(comentario);
			} else {
				return null;
			}
		} else {

			return null;
		}
	}

	public ComentarioDTO atualizarComentario(Long id, String novoTexto) {
		Optional<Comentario> comentarioOpt = comentarioRepository.findById(id);
		if (comentarioOpt.isPresent()) {
			Comentario comentario = comentarioOpt.get();
			comentario.setTexto(novoTexto);
			comentario = comentarioRepository.save(comentario);
			return comentarioParaComentarioDTO(comentario);
		}
		return null;
	}

	public void excluirComentario(Long id) {
		comentarioRepository.deleteById(id);
	}

	private ComentarioDTO comentarioParaComentarioDTO(Comentario comentario) {
		ComentarioDTO comentarioDTO = new ComentarioDTO();
		comentarioDTO.setTexto(comentario.getTexto());
		comentarioDTO.setData(comentario.getDataCriacao());

		return comentarioDTO;
	}
}
