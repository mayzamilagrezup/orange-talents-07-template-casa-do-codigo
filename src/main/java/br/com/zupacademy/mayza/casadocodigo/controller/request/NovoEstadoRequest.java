package br.com.zupacademy.mayza.casadocodigo.controller.request;

import br.com.zupacademy.mayza.casadocodigo.modelo.Estado;
import br.com.zupacademy.mayza.casadocodigo.modelo.Pais;
import br.com.zupacademy.mayza.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.mayza.casadocodigo.validator.IdValid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Locale;

public class NovoEstadoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @IdValid(domainClass = Pais.class, fieldName = "id",
            message = "Não existe um país cadastrado com o id informado")
    private Long idPais;

    public NovoEstadoRequest(String nome, Long idPais) {
        this.nome = nome.toLowerCase(Locale.ROOT).trim();
        this.idPais = idPais;
    }

    public Estado toEstado(PaisRepository paisRepository) {
        Pais pais = paisRepository.getOne(idPais);
        return new Estado(this.nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
