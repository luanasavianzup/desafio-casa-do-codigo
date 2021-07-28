package br.com.zupacademy.luanasavian.casadocodigo.repository;

import br.com.zupacademy.luanasavian.casadocodigo.model.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long>{
}
