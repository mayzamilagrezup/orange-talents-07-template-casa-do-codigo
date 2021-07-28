package br.com.zupacademy.mayza.casadocodigo.dto.request;

import br.com.zupacademy.mayza.casadocodigo.modelo.Categoria;
import br.com.zupacademy.mayza.casadocodigo.validator.UniqueValid;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValid(domainClass = Categoria.class, fieldName = "nome",
            message = "Já existe uma categoria com esse nome cadastrada")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toCategoria() {
        return new Categoria(this.nome);
    }
}
