package br.com.zupacademy.mayza.casadocodigo.controller;

import br.com.zupacademy.mayza.casadocodigo.controller.request.NovoEstadoRequest;
import br.com.zupacademy.mayza.casadocodigo.modelo.Estado;
import br.com.zupacademy.mayza.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.mayza.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoEstadoRequest request) {
        Optional<Estado> optional = estadoRepository.findByNomeAndPaisId(request.getNome(), request.getIdPais());
        if(!optional.isPresent()) {
            Estado estado = request.toEstado(paisRepository);
            estadoRepository.save(estado);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estado.getId()).toUri();
            return ResponseEntity.ok().header(HttpHeaders.LOCATION, uri.toString()).build();
        }
        return ResponseEntity.badRequest().build();
    }
}