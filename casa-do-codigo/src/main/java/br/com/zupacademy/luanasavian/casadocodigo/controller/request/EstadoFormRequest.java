package br.com.zupacademy.luanasavian.casadocodigo.controller.request;

import br.com.zupacademy.luanasavian.casadocodigo.interfaces.ExistsId;
import br.com.zupacademy.luanasavian.casadocodigo.interfaces.UniqueValue;
import br.com.zupacademy.luanasavian.casadocodigo.model.Estado;
import br.com.zupacademy.luanasavian.casadocodigo.model.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoFormRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public EstadoFormRequest(@NotBlank String nome, @NotNull Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado toModel(EntityManager manager) {
        @NotNull Pais pais = manager.find(Pais.class, paisId);
        return new Estado(nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
