package br.com.zupacademy.luanasavian.casadocodigo.controller;

import br.com.zupacademy.luanasavian.casadocodigo.controller.request.EstadoFormRequest;
import br.com.zupacademy.luanasavian.casadocodigo.model.Estado;
import br.com.zupacademy.luanasavian.casadocodigo.repository.EstadoRepository;
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
@RequestMapping("/estados")
public class EstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid EstadoFormRequest form, UriComponentsBuilder uriBuilder) {
        Estado estado = form.toModel(entityManager);
        estadoRepository.save(estado);

        URI uri = uriBuilder.path("/estados/{id}").buildAndExpand(estado.getId()).toUri();
    }
}
