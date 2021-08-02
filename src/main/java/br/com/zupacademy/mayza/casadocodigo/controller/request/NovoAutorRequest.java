package br.com.zupacademy.mayza.casadocodigo.controller.request;

import br.com.zupacademy.mayza.casadocodigo.modelo.Autor;
import br.com.zupacademy.mayza.casadocodigo.validator.UniqueValid;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoAutorRequest {


    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValid(domainClass = Autor.class, fieldName = "email",
            message ="Já existe um autor com esse email cadastrado")
    private String email;

    @NotBlank
    @Length(max = 400)
    private String descricao;

    public NovoAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toAutor() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
