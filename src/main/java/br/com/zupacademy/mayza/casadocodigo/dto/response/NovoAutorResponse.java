package br.com.zupacademy.mayza.casadocodigo.dto.response;

import br.com.zupacademy.mayza.casadocodigo.modelo.Autor;
import java.time.format.DateTimeFormatter;

public class NovoAutorResponse {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private String instanteCriado;


    public NovoAutorResponse(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.instanteCriado = autor.getInstanteCriado().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    public String getInstanteCriado() {
        return instanteCriado;
    }
}
