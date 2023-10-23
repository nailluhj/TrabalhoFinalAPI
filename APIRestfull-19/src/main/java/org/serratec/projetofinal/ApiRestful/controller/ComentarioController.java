package org.serratec.projetofinal.ApiRestful.controller;

import java.util.List;

import org.serratec.projetofinal.ApiRestful.DTO.ComentarioDTO;
import org.serratec.projetofinal.ApiRestful.DTO.UsuarioDTO;
import org.serratec.projetofinal.ApiRestful.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> listarComentariosPorPostagem(@RequestParam(name = "postagemId") Long postagemId) {
        List<ComentarioDTO> comentario = comentarioService.listarComentariosPorPostagem(postagemId);
        return ResponseEntity.ok(comentario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> buscarComentarioPorId(@PathVariable Long id) {
    	if (id != null) {
    		 return ResponseEntity.badRequest().build();
    	}
        ComentarioDTO comentario = comentarioService.buscarComentarioPorId(id);
        if (comentario != null) {
            return ResponseEntity.ok(comentario);
        }
        return ResponseEntity.notFound().build();
     }
    
    
    @PostMapping
    public ResponseEntity<ComentarioDTO> inserirComentario(@RequestBody ComentarioDTO comentarioDTO) {
//        Long idPostagem = comentarioDTO.getIdPostagem();
//        String texto = comentarioDTO.getTexto();
        ComentarioDTO comentario = comentarioService.inserirComentario(comentarioDTO);

        if (comentario != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(comentario);
        }
        return ResponseEntity.notFound().build();
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<ComentarioDTO> atualizarComentario(@PathVariable Long id, @RequestBody ComentarioDTO comentarioDTO) {
        ComentarioDTO comentario = comentarioService.atualizarComentario(id, comentarioDTO.getTexto());
        if (comentario != null) {
            return ResponseEntity.ok(comentario);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirComentario(@PathVariable Long id) {
        comentarioService.excluirComentario(id);
        return ResponseEntity.noContent().build();
    }
}

