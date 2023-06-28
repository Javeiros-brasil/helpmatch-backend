package br.com.helpmatch.helpmatchbackend.repository;

import br.com.helpmatch.helpmatchbackend.entities.Profissional;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {}
