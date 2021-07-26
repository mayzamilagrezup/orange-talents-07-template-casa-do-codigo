package br.com.zupacademy.mayza.casadocodigo.controller;

import br.com.zupacademy.mayza.casadocodigo.controller.dto.NovoAutorDto;
import br.com.zupacademy.mayza.casadocodigo.controller.form.NovoAutorForm;
import br.com.zupacademy.mayza.casadocodigo.modelo.Autor;
import br.com.zupacademy.mayza.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.mayza.casadocodigo.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EmailValidator emailValidator;

    @InitBinder
    public void initAutorBinder(WebDataBinder binder) {
        binder.addValidators(emailValidator);
    }

    @PostMapping
    public ResponseEntity<NovoAutorDto> cadastrar(@RequestBody @Valid NovoAutorForm form) {
        Autor autor =  autorRepository.save(form.toAutor());
        return ResponseEntity.ok(new NovoAutorDto(autor));

    }




}
