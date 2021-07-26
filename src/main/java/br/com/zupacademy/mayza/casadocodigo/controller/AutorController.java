package br.com.zupacademy.mayza.casadocodigo.controller;

import br.com.zupacademy.mayza.casadocodigo.controller.dto.NovoAutorDto;
import br.com.zupacademy.mayza.casadocodigo.controller.form.NovoAutorForm;
import br.com.zupacademy.mayza.casadocodigo.modelo.Autor;
import br.com.zupacademy.mayza.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<NovoAutorDto> cadastrar(@RequestBody @Valid NovoAutorForm form) {
        Autor autor =  autorRepository.save(form.toAutor());
        return ResponseEntity.ok(new NovoAutorDto(autor));

    }




}
