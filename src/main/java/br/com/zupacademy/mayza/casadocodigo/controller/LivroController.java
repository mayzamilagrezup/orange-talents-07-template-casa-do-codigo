package br.com.zupacademy.mayza.casadocodigo.controller;

import br.com.zupacademy.mayza.casadocodigo.controller.request.NovoLivroRequest;
import br.com.zupacademy.mayza.casadocodigo.controller.response.DetalheLivroResponse;
import br.com.zupacademy.mayza.casadocodigo.controller.response.ListaLivrosResponse;
import br.com.zupacademy.mayza.casadocodigo.modelo.Livro;
import br.com.zupacademy.mayza.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoLivroRequest request) {
        Livro livro = livroRepository.save(request.toLivro(manager));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.ok().header(HttpHeaders.LOCATION, uri.toString()).build();
    }

    @GetMapping
    public ResponseEntity<List<ListaLivrosResponse>> listarLivros() {
        List<Livro> livros = livroRepository.findAll();
        List<ListaLivrosResponse> livrosDTO = livros.stream().map(ListaLivrosResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(livrosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheLivroResponse> detalheLivro(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return ResponseEntity.ok().body(new DetalheLivroResponse(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
