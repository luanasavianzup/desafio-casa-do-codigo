package br.com.zupacademy.luanasavian.casadocodigo.controller.form;

import br.com.zupacademy.luanasavian.casadocodigo.model.Autor;
import br.com.zupacademy.luanasavian.casadocodigo.repository.AutorRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {

    @NotBlank(message = "Nome obrigatório!")
    private String nome;
    @NotBlank(message = "Insira o e-mail!")
    @Email
    private String email;
    @NotBlank(message = "Descrição obrigatória!")
    @Size(max = 400)
    private String descricao;

    public AutorForm(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
