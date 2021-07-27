package br.com.zupacademy.luanasavian.casadocodigo.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome obrigatório!")
    private String nome;
    @NotBlank(message = "Insira o e-mail!")
    @Column(unique = true)
    @Email
    private String email;
    @NotBlank(message = "Descrição obrigatória!")
    @Size(max = 400)
    private String descricao;
    private LocalDateTime instanteCriacao = LocalDateTime.now();

    @Deprecated
    public Autor() {

    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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
