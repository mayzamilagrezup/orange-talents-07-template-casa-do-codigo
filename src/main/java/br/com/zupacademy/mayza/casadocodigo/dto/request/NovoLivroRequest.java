package br.com.zupacademy.mayza.casadocodigo.dto.request;

import br.com.zupacademy.mayza.casadocodigo.modelo.Autor;
import br.com.zupacademy.mayza.casadocodigo.modelo.Categoria;
import br.com.zupacademy.mayza.casadocodigo.modelo.Livro;
import br.com.zupacademy.mayza.casadocodigo.validator.IdValid;
import br.com.zupacademy.mayza.casadocodigo.validator.UniqueValid;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    @UniqueValid(domainClass = Livro.class, fieldName = "titulo",
            message = "Já existe um livro com esse título")
    private String titulo;

    @NotBlank
    @Length(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @DecimalMin(value = "20.0")
    private BigDecimal preco;

    @NotNull
    @Min(value = 100)
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValid(domainClass = Livro.class, fieldName = "isbn",
            message = "Já existe um livro cadastrado com esse isbn.")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @NotNull
    private LocalDate dataPublicacao;

    @NotNull
    @IdValid(domainClass = Categoria.class, fieldName = "id", message = "Não existe uma categoria cadastrada com o id informado")
    private Long idCategoria;

    @NotNull
    @IdValid(domainClass = Autor.class, fieldName = "id",  message = "Não existe um autor cadastrado com o id informado")
    private Long idAutor;


    public NovoLivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toLivro(EntityManager manager) {
        Autor autor = manager.find(Autor.class, idAutor);
        Categoria categoria = manager.find(Categoria.class, idCategoria);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn, this.dataPublicacao, categoria, autor);
    }

   public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

}
