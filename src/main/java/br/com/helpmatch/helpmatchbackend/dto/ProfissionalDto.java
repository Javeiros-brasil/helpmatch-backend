package br.com.helpmatch.helpmatchbackend.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProfissionalDto {
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String nomeMae;
    private String nomePai;
    private Long contatoId;
    private Long enderecoId;
    private Long acessoId;
    private ContatoDto contato;
    private EnderecoDto endereco;
    private AcessoDto acesso;
    
}
