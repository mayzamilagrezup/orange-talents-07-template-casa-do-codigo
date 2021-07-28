package br.com.zupacademy.mayza.casadocodigo.controller;

import br.com.zupacademy.mayza.casadocodigo.dto.request.NovoLivroRequest;
import br.com.zupacademy.mayza.casadocodigo.dto.response.DetalheLivroResponse;
import br.com.zupacademy.mayza.casadocodigo.dto.response.ListaLivrosResponse;
import br.com.zupacademy.mayza.casadocodigo.dto.response.NovoLivroResponse;
import br.com.zupacademy.mayza.casadocodigo.modelo.Livro;
import br.com.zupacademy.mayza.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
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
    @Transactional
    public ResponseEntity<NovoLivroResponse> cadastrar(@RequestBody @Valid NovoLivroRequest request) {
        Livro livro = livroRepository.save(request.toLivro(manager));
        return ResponseEntity.ok(new NovoLivroResponse(livro));
    }

    @GetMapping
    public ResponseEntity<List<ListaLivrosResponse>> listarLivros() {
        List<Livro> livros = livroRepository.findAll();
        List<ListaLivrosResponse> livrosDTO = livros.stream().map(ListaLivrosResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(livrosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheLivroResponse> detalheLivro(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return ResponseEntity.ok(new DetalheLivroResponse(livro.get()));
        }

        return ResponseEntity.notFound().build();

    }

}
