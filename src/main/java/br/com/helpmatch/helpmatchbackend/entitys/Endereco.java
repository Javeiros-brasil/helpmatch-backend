package br.com.helpmatch.helpmatchbackend.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String cep;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String complemento;
    @NotBlank
    private String numero;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    @OneToOne
    private Usuario usuario;

}
