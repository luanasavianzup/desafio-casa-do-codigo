package br.com.zupacademy.luanasavian.casadocodigo.repository;

import br.com.zupacademy.luanasavian.casadocodigo.model.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{
}
