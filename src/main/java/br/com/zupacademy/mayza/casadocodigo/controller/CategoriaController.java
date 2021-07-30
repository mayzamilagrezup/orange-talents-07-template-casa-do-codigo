package br.com.zupacademy.mayza.casadocodigo.controller;

import br.com.zupacademy.mayza.casadocodigo.dto.request.NovaCategoriaRequest;
import br.com.zupacademy.mayza.casadocodigo.dto.response.NovaCategoriaResponse;
import br.com.zupacademy.mayza.casadocodigo.modelo.Categoria;
import br.com.zupacademy.mayza.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<NovaCategoriaResponse> cadastrar(@RequestBody @Valid NovaCategoriaRequest form) {
        Categoria categoria =  categoriaRepository.save(form.toCategoria());
        return ResponseEntity.ok().body(new NovaCategoriaResponse(categoria));

    }
}
