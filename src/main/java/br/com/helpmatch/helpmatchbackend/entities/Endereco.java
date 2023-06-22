package br.com.helpmatch.helpmatchbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL )
    private Usuario usuario;

}
