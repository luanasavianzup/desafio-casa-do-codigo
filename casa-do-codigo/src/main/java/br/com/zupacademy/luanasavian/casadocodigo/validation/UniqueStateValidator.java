package br.com.zupacademy.luanasavian.casadocodigo.validation;

import br.com.zupacademy.luanasavian.casadocodigo.interfaces.UniqueState;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueStateValidator implements ConstraintValidator<UniqueState, Object> {

    @PersistenceContext
    private EntityManager manager;

    private String domainAttribute;
    private String paisIdField;
    private Class<?> klass;

    @Override
    public void initialize(UniqueState params) {
        domainAttribute = params.estadoField();
        this.paisIdField = params.paisIdField();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select " + domainAttribute + " from " + klass.getName()  +
                "  where " + paisIdField+ "=:paisId and " + domainAttribute + "=:value");
        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "Foi encontrado mais de um " + klass + "com o atributo" + domainAttribute + " = " + value);

        return list.isEmpty();
    }

}
