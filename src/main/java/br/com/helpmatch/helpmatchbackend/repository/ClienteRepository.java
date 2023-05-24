package br.com.helpmatch.helpmatchbackend.repository;

import br.com.helpmatch.helpmatchbackend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
