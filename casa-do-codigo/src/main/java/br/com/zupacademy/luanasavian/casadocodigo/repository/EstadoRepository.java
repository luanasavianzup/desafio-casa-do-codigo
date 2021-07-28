package br.com.zupacademy.luanasavian.casadocodigo.repository;

import br.com.zupacademy.luanasavian.casadocodigo.model.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long>{
    Optional<Estado> findByNome(String nome);
}
