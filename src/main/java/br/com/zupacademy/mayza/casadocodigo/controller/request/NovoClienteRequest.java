package br.com.zupacademy.mayza.casadocodigo.controller.request;

import br.com.zupacademy.mayza.casadocodigo.modelo.Cliente;
import br.com.zupacademy.mayza.casadocodigo.modelo.Estado;
import br.com.zupacademy.mayza.casadocodigo.modelo.Pais;
import br.com.zupacademy.mayza.casadocodigo.validator.CpfOuCnpj;
import br.com.zupacademy.mayza.casadocodigo.validator.IdValid;
import br.com.zupacademy.mayza.casadocodigo.validator.UniqueValid;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoClienteRequest {

    @NotBlank
    @Email
    @UniqueValid(domainClass = Cliente.class, fieldName = "email", message = "Já existe um cliente cadastrado com esse email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @UniqueValid(domainClass = Cliente.class, fieldName = "documento", message = "Já existe um cliente cadastrado com esse documento")
    @CpfOuCnpj
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @IdValid(domainClass = Pais.class, fieldName = "id", message = "Não existe cadastro de País com o id informado")
    private Long idPais;

    @IdValid(domainClass = Estado.class, fieldName = "id", message = "Não existe cadastro de Estado com o id informado", required=false)
    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public NovoClienteRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long idPais, Long idEstado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toCliente(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);

        Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
                this.complemento, this.cidade, pais, this.telefone, this.cep);

        if(idEstado != null) {
            Estado estado = manager.find(Estado.class, idEstado);
            cliente.setEstado(estado);
        }

        if (!pais.getEstados().isEmpty() && idEstado == null){
            throw new IllegalArgumentException("Estado não pode ser vazio");
        }

        return cliente;
    }

}
