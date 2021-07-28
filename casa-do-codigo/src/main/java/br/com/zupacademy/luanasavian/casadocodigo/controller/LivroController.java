package br.com.zupacademy.luanasavian.casadocodigo.controller;

import br.com.zupacademy.luanasavian.casadocodigo.controller.request.LivroFormRequest;
import br.com.zupacademy.luanasavian.casadocodigo.model.Livro;
import br.com.zupacademy.luanasavian.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.luanasavian.casadocodigo.response.DetalhesLivroDtoResponse;
import br.com.zupacademy.luanasavian.casadocodigo.response.LivroDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    @Transactional
    public List<LivroDtoResponse> getList() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream().map(LivroDtoResponse::new).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesLivroDtoResponse> getDetalhes(@PathVariable("id") Long id) {
        Livro livroBuscado = entityManager.find(Livro.class, id);
        //find retorna nulo, 404. Verificação.
        if (livroBuscado == null) {
            return ResponseEntity.notFound().build();
        }
        DetalhesLivroDtoResponse detalhesLivroDtoResponse = new DetalhesLivroDtoResponse(livroBuscado);
        return ResponseEntity.ok(detalhesLivroDtoResponse);
    }

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid LivroFormRequest form, UriComponentsBuilder uriBuilder) {
        Livro livro = form.toModel(entityManager);
        livroRepository.save(livro);

        URI uri = uriBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();
    }
}
