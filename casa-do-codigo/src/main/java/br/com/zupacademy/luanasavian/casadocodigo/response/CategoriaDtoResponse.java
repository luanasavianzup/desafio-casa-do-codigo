package br.com.zupacademy.luanasavian.casadocodigo.response;

import br.com.zupacademy.luanasavian.casadocodigo.model.Categoria;


public class CategoriaDtoResponse {

    private Long id;
    private String nome;

    public CategoriaDtoResponse(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {

        return id;
    }

    public String getNome() {

        return nome;
    }

    }
