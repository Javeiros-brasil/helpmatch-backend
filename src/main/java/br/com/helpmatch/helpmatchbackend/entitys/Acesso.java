package br.com.helpmatch.helpmatchbackend.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class Acesso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private boolean ativo;
    @NotBlank
    private boolean aceitouTermos;
    @NotBlank
    @OneToOne
    private Usuario usuario;



}
