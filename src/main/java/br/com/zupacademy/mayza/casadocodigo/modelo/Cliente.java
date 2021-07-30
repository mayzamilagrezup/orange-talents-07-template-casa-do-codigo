package br.com.zupacademy.mayza.casadocodigo.modelo;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, unique = true)
    private String documento;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String cidade;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String cep;

    @Deprecated
    public Cliente() {
    }

    public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Pais pais, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        if(!estado.pertenceAPais(this.pais)) {
            throw new IllegalArgumentException("Estado não pertence ao pais");
        }
    }

    public Estado getEstado() {
        return estado;
    }

    public Long getId() {
        return id;
    }
}
