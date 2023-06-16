package br.com.helpmatch.helpmatchbackend.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;


@Entity
@Data
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private Date dataAgendamento;
    @NotBlank
    private int statusAgendamento;
    @NotBlank
    private int clienteId;
    @NotBlank
    private int servicoId;
    @NotBlank
    private int avaliacao;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;


    public void realizarAgendamento(){

    }
    public void cancelarAgendamento(){

    }


}
