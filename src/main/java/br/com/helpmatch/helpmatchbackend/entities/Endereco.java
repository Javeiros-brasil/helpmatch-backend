package br.com.helpmatch.helpmatchbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(nullable = false)
    private String cep;
    
    @Column(nullable = false)
    private String logradouro;
    
    @Column(nullable = false)
    private String complemento;
    
    @Column(nullable = false)
    private String numero;
    
    @Column(nullable = false)
    private String bairro;
    
    @Column(nullable = false)
    private String cidade;
    
    @Column(nullable = false)
    private String estado;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL )
    private Usuario usuario;

}
