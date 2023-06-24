package br.com.helpmatch.helpmatchbackend.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Data
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String celular;
    
    @Column(nullable = false)
    private String email;

    @OneToOne(mappedBy = "contato", cascade = CascadeType.ALL)
    private Usuario usuario;

}
