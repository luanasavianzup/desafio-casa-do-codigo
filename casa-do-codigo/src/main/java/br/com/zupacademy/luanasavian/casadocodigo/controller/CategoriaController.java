package br.com.zupacademy.luanasavian.casadocodigo.controller;

import br.com.zupacademy.luanasavian.casadocodigo.controller.request.CategoriaFormRequest;
import br.com.zupacademy.luanasavian.casadocodigo.model.Categoria;
import br.com.zupacademy.luanasavian.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid CategoriaFormRequest form, UriComponentsBuilder uriBuilder) {
        Categoria categoria = form.toModel();
        categoriaRepository.save(categoria);

        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
    }
}
