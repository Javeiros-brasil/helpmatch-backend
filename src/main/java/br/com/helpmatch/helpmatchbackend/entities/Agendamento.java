package br.com.helpmatch.helpmatchbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

import org.hibernate.annotations.Formula;

import br.com.helpmatch.helpmatchbackend.enums.AgendamentoEnum;


@Entity
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Enumerated(EnumType.ORDINAL)
    private AgendamentoEnum statusAgendamento;
    
    private int avaliacao;
    private LocalDate dataAgendamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @Formula("cliente_id")
    private Long clienteId;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
    
    @Formula("servico_id")
    private Long servicoId;
}
