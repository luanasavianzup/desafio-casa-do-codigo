package br.com.zupacademy.luanasavian.casadocodigo.controller.request;

import br.com.zupacademy.luanasavian.casadocodigo.interfaces.ExistsId;
import br.com.zupacademy.luanasavian.casadocodigo.interfaces.UniqueValue;
import br.com.zupacademy.luanasavian.casadocodigo.model.Autor;
import br.com.zupacademy.luanasavian.casadocodigo.model.Cliente;
import br.com.zupacademy.luanasavian.casadocodigo.model.Estado;
import br.com.zupacademy.luanasavian.casadocodigo.model.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteFormRequest {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;
    private Long estadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteFormRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                                  @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                                  @NotBlank String cidade, @NotNull Long paisId, @NotNull Long estadoId, @NotBlank String telefone,
                                  @NotBlank String cep) {
        super();
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toModel(EntityManager manager) {

        Pais pais = manager.find(Pais.class, paisId);

        Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);

        if (estadoId!= null) {
            cliente.setEstado(manager.find(Estado.class, estadoId));
        }

        return cliente;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

}
