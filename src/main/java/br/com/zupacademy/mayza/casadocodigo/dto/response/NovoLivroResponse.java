package br.com.zupacademy.mayza.casadocodigo.dto.response;

import br.com.zupacademy.mayza.casadocodigo.modelo.Livro;
import java.math.BigDecimal;
import java.time.LocalDate;


public class NovoLivroResponse {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private Long idCategoria;
    private String nomeCategoria;
    private Long idAutor;
    private String nomeAutor;

    public NovoLivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.idCategoria = livro.getCategoria().getId();
        this.nomeCategoria = livro.getCategoria().getNome();
        this.idAutor = livro.getAutor().getId();
        this.nomeAutor = livro.getAutor().getNome();

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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}
