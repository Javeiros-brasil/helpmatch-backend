package br.com.helpmatch.helpmatchbackend.dto;

import java.time.LocalDate;

import br.com.helpmatch.helpmatchbackend.util.validation.CPF;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfissionalDto {
	
    private Long id;
    @NotBlank
    private String nomeCompleto;
    @CPF
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;
    @NotBlank
    private String nomeMae;
    private String nomePai;
    
    private Long contatoId;
    private Long enderecoId;
    private Long acessoId;

    @NotNull
    @Valid
    private ContatoDto contato;

    @NotNull
    @Valid
    private EnderecoDto endereco;

    @NotNull
    @Valid
    private AcessoDto acesso;

}
