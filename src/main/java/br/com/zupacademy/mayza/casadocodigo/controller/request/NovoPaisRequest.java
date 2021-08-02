package br.com.zupacademy.mayza.casadocodigo.controller.request;

import br.com.zupacademy.mayza.casadocodigo.modelo.Pais;
import br.com.zupacademy.mayza.casadocodigo.validator.UniqueValid;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    @UniqueValid(domainClass = Pais.class, fieldName = "nome",
            message = "Já existe um país com esse nome cadastrado")
    private String nome;

    public Pais toPais() {
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
