package br.com.zupacademy.mayza.casadocodigo.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false)
    private String resumo;

    @Column(nullable = false)
    private String sumario;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Integer numeroPaginas;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private LocalDate dataPublicacao;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}

