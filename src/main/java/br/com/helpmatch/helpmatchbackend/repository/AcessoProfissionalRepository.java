package br.com.helpmatch.helpmatchbackend.repository;

/*
@Author Rafael e Ruan
*/

import br.com.helpmatch.helpmatchbackend.entities.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface AcessoProfissionalRepository extends JpaRepository<Acesso, Long> {
    @Query("SELECT a FROM #{Acesso} a WHERE a.username=:username")
    Optional<Acesso> findByUsername(@Param("username") String username);
}