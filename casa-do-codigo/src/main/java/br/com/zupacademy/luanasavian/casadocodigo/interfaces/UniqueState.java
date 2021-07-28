package br.com.zupacademy.luanasavian.casadocodigo.interfaces;

import br.com.zupacademy.luanasavian.casadocodigo.validation.UniqueStateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {UniqueStateValidator.class})
@Target({ FIELD})
@Retention(RUNTIME)
public @interface UniqueState {

    String message() default "Foi encontrado mais de um cadastro com o mesmo atributo!";

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    String estadoField();
    String paisIdField();
    Class<?> domainClass();

}

