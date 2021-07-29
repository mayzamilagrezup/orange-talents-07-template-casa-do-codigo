package br.com.zupacademy.mayza.casadocodigo.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados;

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

    public List<Estado> getEstados() {
        return estados;
    }
}
