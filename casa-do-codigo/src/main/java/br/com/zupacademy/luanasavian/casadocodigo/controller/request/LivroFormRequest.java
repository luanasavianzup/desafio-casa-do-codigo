package br.com.zupacademy.luanasavian.casadocodigo.controller.request;


import br.com.zupacademy.luanasavian.casadocodigo.interfaces.ExistsId;
import br.com.zupacademy.luanasavian.casadocodigo.interfaces.UniqueValue;
import br.com.zupacademy.luanasavian.casadocodigo.model.Autor;
import br.com.zupacademy.luanasavian.casadocodigo.model.Categoria;
import br.com.zupacademy.luanasavian.casadocodigo.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroFormRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private int numeroPaginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long categoriaId;
    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    @Deprecated
    public LivroFormRequest() {

    }

    public LivroFormRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
                            @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco,
                            @NotNull @Min(100) int numeroPaginas, @NotBlank String isbn,
                            @NotNull LocalDate dataPublicacao, @NotNull Long categoriaId, @NotNull Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public Livro toModel(EntityManager em) {
        @NotNull Autor autor = em.find(Autor.class, autorId);
        @NotNull Categoria categoria = em.find(Categoria.class, categoriaId);
        return new Livro(titulo, resumo, sumario, preco, numeroPaginas,
                        isbn, dataPublicacao, categoria, autor);
    }

    //json não está desserializando com a data no parâmetro pelo construtor
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
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

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }
}
