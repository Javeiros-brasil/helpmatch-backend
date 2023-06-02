package br.com.helpmatch.helpmatchbackend.entity;

import java.time.LocalDate;


import lombok.Data;

@Data
public class ProfissionalEntity {
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String nomeMae;
    private String nomePai;
    private Long contatoId;
    private Long enderecoId;
    private Long acessoId;
    private ContatoEntity contato;
    private EnderecoEntity endereco;
    private AcessoEntity acesso;
}
