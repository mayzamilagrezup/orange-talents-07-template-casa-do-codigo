package br.com.zupacademy.mayza.casadocodigo.controller;

import br.com.zupacademy.mayza.casadocodigo.dto.request.NovoEstadoRequest;
import br.com.zupacademy.mayza.casadocodigo.dto.response.NovoEstadoResponse;
import br.com.zupacademy.mayza.casadocodigo.modelo.Estado;
import br.com.zupacademy.mayza.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.mayza.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<NovoEstadoResponse> cadastrar(@RequestBody @Valid NovoEstadoRequest request) {
        Optional<Estado> optional = estadoRepository.findByNomeAndPaisId(request.getNome(), request.getIdPais());
        if(!optional.isPresent()) {
            Estado estado = request.toEstado(paisRepository);
            estadoRepository.save(estado);
            return ResponseEntity.ok(new NovoEstadoResponse(estado));
        }
        return ResponseEntity.badRequest().build();


    }





}
