package br.com.helpmatch.helpmatchbackend.controller.request;

import br.com.helpmatch.helpmatchbackend.util.validation.CPF;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfissionalRequest {
    @NotBlank
    private String nomeCompleto;
    @CPF
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;
    @NotBlank
    private String nomeMae;
    @NotBlank
    private String nomePai;
    @NotNull
    @Valid
    private ContatoRequest contato;
    @NotNull
    @Valid
    private EnderecoRequest endereco;
    @NotNull
    @Valid
    private AcessoRequest acesso;
}
