package br.com.zupacademy.mayza.casadocodigo.dto.response;

import br.com.zupacademy.mayza.casadocodigo.modelo.Pais;

public class NovoPaisResponse {

    private Long id;

    public NovoPaisResponse(Pais pais) {
        this.id = pais.getId();
    }

    public Long getId() {
        return id;
    }
}
