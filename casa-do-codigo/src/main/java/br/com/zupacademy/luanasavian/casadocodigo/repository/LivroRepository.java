package br.com.zupacademy.luanasavian.casadocodigo.repository;

import br.com.zupacademy.luanasavian.casadocodigo.model.Livro;
import br.com.zupacademy.luanasavian.casadocodigo.response.LivroDtoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository <Livro, Long> {
}
