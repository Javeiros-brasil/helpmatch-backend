package br.com.helpmatch.helpmatchbackend.entities;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String descricao;
    
    private Long tempoDuracao;
    
    private BigDecimal preco;
    private BigDecimal precoPromocao;

    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    @Formula("profissional_id")
    private Long profissionalId;
    
    @OneToMany(mappedBy = "servico")
    private List<Agendamento> agendamentos;

}
