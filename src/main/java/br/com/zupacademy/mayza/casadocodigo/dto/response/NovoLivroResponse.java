package br.com.zupacademy.mayza.casadocodigo.dto.response;

import br.com.zupacademy.mayza.casadocodigo.modelo.Livro;

public class NovoLivroResponse {

    private Long id;

    public NovoLivroResponse(Livro livro) {
        this.id = livro.getId();
    }

    public Long getId() {
        return id;
    }
}
