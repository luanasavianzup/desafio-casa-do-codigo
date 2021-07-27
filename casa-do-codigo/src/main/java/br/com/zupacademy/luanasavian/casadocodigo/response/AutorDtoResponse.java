package br.com.zupacademy.luanasavian.casadocodigo.response;

import br.com.zupacademy.luanasavian.casadocodigo.model.Autor;

import java.time.LocalDateTime;

public class AutorDtoResponse {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime instanteCriacao;

    public AutorDtoResponse(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.instanteCriacao = autor.getInstanteCriacao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }
}
