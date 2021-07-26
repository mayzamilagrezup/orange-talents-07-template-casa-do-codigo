package br.com.zupacademy.mayza.casadocodigo.dto.response;

import br.com.zupacademy.mayza.casadocodigo.modelo.Autor;

import java.time.LocalDateTime;

public class NovoAutorResponse {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime instanteCriado;


    public NovoAutorResponse(Autor autor) {
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
