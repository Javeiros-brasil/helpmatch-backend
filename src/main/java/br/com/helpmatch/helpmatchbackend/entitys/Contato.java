package br.com.helpmatch.helpmatchbackend.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String celular;
    @NotBlank
    private String email;
    @NotBlank
    @OneToOne
    private Usuario usuario;

}
