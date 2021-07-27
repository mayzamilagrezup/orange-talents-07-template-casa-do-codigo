package br.com.zupacademy.mayza.casadocodigo.controller;

import br.com.zupacademy.mayza.casadocodigo.dto.request.NovoLivroRequest;
import br.com.zupacademy.mayza.casadocodigo.dto.response.NovoLivroResponse;
import br.com.zupacademy.mayza.casadocodigo.modelo.Livro;
import br.com.zupacademy.mayza.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

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
}
