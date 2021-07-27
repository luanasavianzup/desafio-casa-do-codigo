package br.com.zupacademy.luanasavian.casadocodigo.controller;

import br.com.zupacademy.luanasavian.casadocodigo.controller.request.AutorFormRequest;
import br.com.zupacademy.luanasavian.casadocodigo.response.AutorDtoResponse;
import br.com.zupacademy.luanasavian.casadocodigo.model.Autor;
import br.com.zupacademy.luanasavian.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.luanasavian.casadocodigo.validation.EmailUnicoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EmailUnicoValidator emailValidator;

    @InitBinder
    public void init(WebDataBinder binder) {

        binder.addValidators(emailValidator);
    }

    @PostMapping
    @Transactional //public ResponseEntity<AutorDtoResponse> retorna 201
    public void post(@RequestBody @Valid AutorFormRequest form, UriComponentsBuilder uriBuilder) {
        Autor autor = form.converter();
        autorRepository.save(autor);

        URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
       //return ResponseEntity.created(uri).body(new AutorDtoResponse(autor));
    }
}
