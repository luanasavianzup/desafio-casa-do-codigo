package br.com.zupacademy.luanasavian.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome obrigatório!")
    private String nome;

    @Deprecated
    public Categoria() {
    }

    public Categoria( @NotBlank String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
