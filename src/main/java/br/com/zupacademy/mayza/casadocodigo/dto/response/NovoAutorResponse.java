package br.com.zupacademy.mayza.casadocodigo.dto.response;

import br.com.zupacademy.mayza.casadocodigo.modelo.Autor;

public class NovoAutorResponse {

    private Long id;

    public NovoAutorResponse(Autor autor) {
        this.id = autor.getId();
    }

    public Long getId() {
        return id;
    }

}
