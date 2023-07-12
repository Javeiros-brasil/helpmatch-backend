package br.com.helpmatch.helpmatchbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class AgendamentoDto {
    private Long id;
    private Date dataAgendamento;
    private int statusAgendamento;
    private Long clienteId;
    private Long servicoId;
    private int avaliacao;


}
