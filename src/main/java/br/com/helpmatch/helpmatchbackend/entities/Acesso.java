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
public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(nullable = false, unique=true)
    private String username;
    
    @Column(nullable = false)
    private String password;
    private boolean ativo;
    private boolean aceitouTermos;

    @OneToOne(mappedBy = "acesso",cascade = CascadeType.ALL)
    private Usuario usuario;    
    
}
