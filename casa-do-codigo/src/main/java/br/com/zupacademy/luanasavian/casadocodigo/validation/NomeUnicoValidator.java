package br.com.zupacademy.luanasavian.casadocodigo.validation;

import br.com.zupacademy.luanasavian.casadocodigo.controller.request.CategoriaFormRequest;
import br.com.zupacademy.luanasavian.casadocodigo.model.Categoria;
import br.com.zupacademy.luanasavian.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeUnicoValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {

        return CategoriaFormRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        CategoriaFormRequest form = (CategoriaFormRequest) target;
        Optional<Categoria> possivelNome = categoriaRepository.findByNome(form.getNome());

        if(possivelNome.isPresent()){
            errors.rejectValue("Nome", null, "Já existe uma categoria com o nome " +  form.getNome() + "!" );
        }
    }

}
