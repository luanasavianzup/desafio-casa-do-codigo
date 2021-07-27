package br.com.zupacademy.luanasavian.casadocodigo.validation;

import br.com.zupacademy.luanasavian.casadocodigo.controller.request.AutorFormRequest;
import br.com.zupacademy.luanasavian.casadocodigo.model.Autor;
import br.com.zupacademy.luanasavian.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;
import java.util.Optional;

@Component
public class EmailUnicoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorFormRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        AutorFormRequest form = (AutorFormRequest) target;
        Optional<Autor> possivelAutor = autorRepository.findByEmail(form.getEmail());

        if(possivelAutor.isPresent()){
            errors.rejectValue("email", null, "O e-mail: "+  form.getEmail() + " já existe em nossa base de dados!" );
        }
    }

}
