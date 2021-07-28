package br.com.zupacademy.luanasavian.casadocodigo.controller;

import br.com.zupacademy.luanasavian.casadocodigo.controller.request.PaisFormRequest;
import br.com.zupacademy.luanasavian.casadocodigo.model.Pais;
import br.com.zupacademy.luanasavian.casadocodigo.repository.PaisRepository;
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
@RequestMapping("/paises")
public class PaisController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid PaisFormRequest form, UriComponentsBuilder uriBuilder) {
        Pais pais = form.toModel(entityManager);
        paisRepository.save(pais);

        URI uri = uriBuilder.path("/paises/{id}").buildAndExpand(pais.getId()).toUri();
    }
}
