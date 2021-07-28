package br.com.zupacademy.luanasavian.casadocodigo.interfaces;

import br.com.zupacademy.luanasavian.casadocodigo.validation.ExistsIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({ FIELD})
@Retention(RUNTIME)
public @interface ExistsId {

    String message() default "Este id não existe!";

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String fieldName();
    Class<?> domainClass();
}

