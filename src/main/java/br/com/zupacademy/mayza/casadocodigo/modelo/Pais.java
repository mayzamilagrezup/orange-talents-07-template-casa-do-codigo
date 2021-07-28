package br.com.zupacademy.mayza.casadocodigo.modelo;

import javax.persistence.*;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Pais(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Pais() {
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

}
