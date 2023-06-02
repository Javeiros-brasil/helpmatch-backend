package br.com.helpmatch.helpmatchbackend.controller.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfissionalResponse {
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String nomeMae;
    private String nomePai;
    private ContatoResponse contato;
    private EnderecoResponse endereco;
    private AcessoResponse acesso;
}
