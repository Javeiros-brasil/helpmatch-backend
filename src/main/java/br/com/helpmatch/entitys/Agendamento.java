package br.com.helpmatch.helpmatchbackend.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    public void realizarAgendamento(){

    }
    public void cancelarAgendamento(){

    }


}
