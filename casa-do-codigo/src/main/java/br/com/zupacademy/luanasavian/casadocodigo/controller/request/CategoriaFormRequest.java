package br.com.zupacademy.luanasavian.casadocodigo.controller.request;

import br.com.zupacademy.luanasavian.casadocodigo.interfaces.UniqueValue;
import br.com.zupacademy.luanasavian.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaFormRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public CategoriaFormRequest(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public CategoriaFormRequest() {
    }

    public Categoria converter() {

        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
