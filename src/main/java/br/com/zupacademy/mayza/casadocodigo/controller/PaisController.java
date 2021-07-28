package br.com.zupacademy.mayza.casadocodigo.controller;

import br.com.zupacademy.mayza.casadocodigo.dto.request.NovoPaisRequest;
import br.com.zupacademy.mayza.casadocodigo.dto.response.NovoPaisResponse;
import br.com.zupacademy.mayza.casadocodigo.modelo.Pais;
import br.com.zupacademy.mayza.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<NovoPaisResponse> cadastrar(@RequestBody @Valid NovoPaisRequest request) {
        Pais pais =  paisRepository.save(request.toPais());
        return ResponseEntity.ok().body(new NovoPaisResponse(pais));

    }
}
