package br.com.helpmatch.helpmatchbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.helpmatch.helpmatchbackend.entities.Code;

@Repository
public interface CodeRepository extends JpaRepository<Code, Long> {

	@Query("SELECT c FROM #{#entityName} c WHERE c.email=:email AND c.code=:code")
    Code findByEmailAndCodeVerification(@Param("email") String email, @Param("code") String code);

}
