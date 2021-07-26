package br.com.zupacademy.mayza.casadocodigo.controller.dto;

import br.com.zupacademy.mayza.casadocodigo.modelo.Autor;

import java.time.LocalDateTime;

public class NovoAutorDto {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime instanteCriado;


    public NovoAutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.instanteCriado = autor.getInstanteCriado();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstanteCriado() {
        return instanteCriado;
    }
}
