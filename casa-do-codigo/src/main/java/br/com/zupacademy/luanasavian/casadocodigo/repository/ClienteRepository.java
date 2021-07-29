package br.com.zupacademy.luanasavian.casadocodigo.repository;

import br.com.zupacademy.luanasavian.casadocodigo.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
