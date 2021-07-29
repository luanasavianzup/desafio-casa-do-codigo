package br.com.zupacademy.luanasavian.casadocodigo.controller;

import br.com.zupacademy.luanasavian.casadocodigo.controller.request.CategoriaFormRequest;
import br.com.zupacademy.luanasavian.casadocodigo.controller.request.ClienteFormRequest;
import br.com.zupacademy.luanasavian.casadocodigo.model.Categoria;
import br.com.zupacademy.luanasavian.casadocodigo.model.Cliente;
import br.com.zupacademy.luanasavian.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.luanasavian.casadocodigo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid ClienteFormRequest form, UriComponentsBuilder uriBuilder) {
        Cliente cliente = form.toModel(entityManager);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
    }

}
