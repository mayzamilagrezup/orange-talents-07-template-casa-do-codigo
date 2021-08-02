package br.com.zupacademy.mayza.casadocodigo.controller;

import br.com.zupacademy.mayza.casadocodigo.controller.request.NovoClienteRequest;
import br.com.zupacademy.mayza.casadocodigo.modelo.Cliente;
import br.com.zupacademy.mayza.casadocodigo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;


    @PersistenceContext
    EntityManager manager;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoClienteRequest request) {
        Cliente cliente = clienteRepository.save(request.toCliente(manager));

       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.ok().header(HttpHeaders.LOCATION, uri.toString()).build();
    }

}
