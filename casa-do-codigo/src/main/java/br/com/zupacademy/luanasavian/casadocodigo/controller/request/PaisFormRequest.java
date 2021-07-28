package br.com.zupacademy.luanasavian.casadocodigo.controller.request;

import br.com.zupacademy.luanasavian.casadocodigo.interfaces.UniqueValue;
import br.com.zupacademy.luanasavian.casadocodigo.model.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class PaisFormRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public Pais toModel(EntityManager manager) {
        return new Pais(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
