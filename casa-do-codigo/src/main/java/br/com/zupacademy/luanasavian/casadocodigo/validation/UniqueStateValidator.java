package br.com.zupacademy.luanasavian.casadocodigo.validation;

import br.com.zupacademy.luanasavian.casadocodigo.controller.request.EstadoFormRequest;
import br.com.zupacademy.luanasavian.casadocodigo.interfaces.UniqueState;
import br.com.zupacademy.luanasavian.casadocodigo.model.Estado;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueStateValidator implements ConstraintValidator<UniqueState, EstadoFormRequest> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean isValid(EstadoFormRequest value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select 1 from " + Estado.class.getName()  +
                " e where e.nome = :nome and e.pais.id = :paisId");
        query.setParameter("nome", value.getNome());
        query.setParameter("paisId", value.getPaisId());
        List<?> list = query.getResultList();

        return list.isEmpty();
    }

}
