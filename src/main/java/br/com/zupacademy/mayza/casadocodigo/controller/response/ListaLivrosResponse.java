package br.com.zupacademy.mayza.casadocodigo.controller.response;

import br.com.zupacademy.mayza.casadocodigo.modelo.Livro;

public class ListaLivrosResponse {

    private Long id;
    private String titulo;

    public ListaLivrosResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
