package br.com.zupacademy.mayza.casadocodigo.controller;

import br.com.zupacademy.mayza.casadocodigo.dto.request.NovaCategoriaRequest;
import br.com.zupacademy.mayza.casadocodigo.dto.response.NovaCategoriaResponse;
import br.com.zupacademy.mayza.casadocodigo.modelo.Categoria;
import br.com.zupacademy.mayza.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.mayza.casadocodigo.validator.CategoriaNomeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaNomeValidator categoriaNomeValidator;

    @InitBinder
    public void initAutorBinder(WebDataBinder binder) {
        binder.addValidators(categoriaNomeValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<NovaCategoriaResponse> cadastrar(@RequestBody @Valid NovaCategoriaRequest form) {
        Categoria categoria =  categoriaRepository.save(form.toCategoria());
        return ResponseEntity.ok(new NovaCategoriaResponse(categoria));

    }
}
