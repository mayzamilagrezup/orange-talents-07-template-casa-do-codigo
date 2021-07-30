package br.com.zupacademy.mayza.casadocodigo.repository;

import br.com.zupacademy.mayza.casadocodigo.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
