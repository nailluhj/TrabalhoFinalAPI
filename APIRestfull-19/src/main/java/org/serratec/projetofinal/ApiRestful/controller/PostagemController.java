package org.serratec.projetofinal.ApiRestful.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.projetofinal.ApiRestful.model.Postagem;
import org.serratec.projetofinal.ApiRestful.repository.PostagemRepository;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

	@Autowired
    private PostagemRepository postagemRepository;
	
	@GetMapping
    public ResponseEntity<List<Postagem>> listar() {
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> buscar(@PathVariable Long id) {
        Optional<Postagem> postagemOpt = postagemRepository.findById(id);
        if (postagemOpt.isPresent()) {
            return ResponseEntity.ok(postagemOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Postagem> inserir(@Valid @RequestBody Postagem postagem) {
        postagem = postagemRepository.save(postagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(postagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postagem> atualizar(@PathVariable Long id, @Valid @RequestBody Postagem postagem) {
        Optional<Postagem> postagemOpt = postagemRepository.findById(id);
        if (postagemOpt.isPresent()) {
            postagem.setId(id);
            postagemRepository.save(postagem);
            return ResponseEntity.ok(postagem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        Optional<Postagem> postagemOpt = postagemRepository.findById(id);
        if (postagemOpt.isPresent()) {
            postagemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}