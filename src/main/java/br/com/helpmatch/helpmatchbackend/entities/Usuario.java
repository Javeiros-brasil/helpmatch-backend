package br.com.helpmatch.helpmatchbackend.entities;


import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Formula;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id")
    private Contato contato;

    @Formula("contato_id")
    private Long contatoId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    
    @Formula("endereco_id")
    private Long enderecoId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acesso_id")
    private Acesso acesso;

    @Formula("acesso_id")
    private Long acessoId;

}

