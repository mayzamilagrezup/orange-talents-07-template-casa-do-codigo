package br.com.zupacademy.mayza.casadocodigo.dto.response;

import br.com.zupacademy.mayza.casadocodigo.modelo.Categoria;

public class NovaCategoriaResponse {

    private Long id;

    public NovaCategoriaResponse(Categoria categoria) {
        this.id = categoria.getId();
    }

    public Long getId() {
        return id;
    }

}
