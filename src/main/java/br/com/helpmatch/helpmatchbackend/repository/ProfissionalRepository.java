package br.com.helpmatch.helpmatchbackend.repository;

import br.com.helpmatch.helpmatchbackend.entities.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {}
