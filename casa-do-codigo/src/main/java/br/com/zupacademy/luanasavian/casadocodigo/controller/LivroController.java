package br.com.zupacademy.luanasavian.casadocodigo.controller;

import br.com.zupacademy.luanasavian.casadocodigo.controller.request.LivroFormRequest;
import br.com.zupacademy.luanasavian.casadocodigo.model.Livro;
import br.com.zupacademy.luanasavian.casadocodigo.repository.LivroRepository;
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
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid LivroFormRequest form, UriComponentsBuilder uriBuilder) {
        Livro livro = form.toModel(entityManager);
        livroRepository.save(livro);

        URI uri = uriBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();
    }
}
