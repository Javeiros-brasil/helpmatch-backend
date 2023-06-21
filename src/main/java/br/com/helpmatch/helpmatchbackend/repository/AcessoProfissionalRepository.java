package br.com.helpmatch.helpmatchbackend.repository;

/*
@Author Rafael e Ruan
*/

import br.com.helpmatch.helpmatchbackend.entitys.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AcessoProfissionalRepository extends JpaRepository<Acesso, Long> {
    Optional<Acesso> findByUsername(String username);
}