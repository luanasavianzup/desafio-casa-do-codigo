package br.com.zupacademy.luanasavian.casadocodigo.response;

import br.com.zupacademy.luanasavian.casadocodigo.model.Livro;

public class LivroDtoResponse {

    private Long id;
    private String titulo;

    public LivroDtoResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
