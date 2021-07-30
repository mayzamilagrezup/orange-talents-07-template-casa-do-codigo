package br.com.zupacademy.mayza.casadocodigo.dto.response;

import br.com.zupacademy.mayza.casadocodigo.modelo.Estado;

public class NovoEstadoResponse {

    private Long id;

    public NovoEstadoResponse(Estado estado) {
        this.id = estado.getId();
    }

    public Long getId() {
        return id;
    }
}
