package br.com.zupacademy.mayza.casadocodigo.repository;

import br.com.zupacademy.mayza.casadocodigo.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
