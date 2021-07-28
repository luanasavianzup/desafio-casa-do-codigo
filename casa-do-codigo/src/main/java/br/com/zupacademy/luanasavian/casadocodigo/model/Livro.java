package br.com.zupacademy.luanasavian.casadocodigo.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    private BigDecimal preco;
    @NotNull
    private int numeroPaginas;
    @NotBlank
    private String isbn;
    @NotNull
    private LocalDate dataPublicacao;
    @ManyToOne
    private @NotNull @Valid Categoria categoria;
    @ManyToOne
    private @NotNull @Valid Autor autor;

    @Deprecated
    public Livro() {

    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
                 @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Min(100) int numeroPaginas, @NotBlank String isbn,
                 @NotNull LocalDate dataPublicacao, @NotNull @Valid Categoria categoria,
                 @NotNull @Valid Autor autor) {
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

    public int getNumeroPaginas() {
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
