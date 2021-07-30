package br.com.zupacademy.mayza.casadocodigo.controller;

import br.com.zupacademy.mayza.casadocodigo.dto.request.NovoClienteRequest;
import br.com.zupacademy.mayza.casadocodigo.dto.response.NovoClienteResponse;
import br.com.zupacademy.mayza.casadocodigo.modelo.Cliente;
import br.com.zupacademy.mayza.casadocodigo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;


  @PersistenceContext
   EntityManager manager;

   @PostMapping
   public ResponseEntity<NovoClienteResponse> cadastrar(@RequestBody @Valid NovoClienteRequest request) {
        Cliente cliente = clienteRepository.save(request.toCliente(manager));
        return ResponseEntity.ok().body(new NovoClienteResponse(cliente));
    }

}
