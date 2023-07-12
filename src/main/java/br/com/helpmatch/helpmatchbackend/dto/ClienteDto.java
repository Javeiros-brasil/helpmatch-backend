package br.com.helpmatch.helpmatchbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ClienteDto {

    private Long id;
    private String nome_completo;
    private String cpf;
    private Date dataNascimento;
    private String nomeMae;
    private String nomePai;
    private Long contatoId;
    private Long enderecoId;
    private Long acessoId;

    private EnderecoDto endereco;
    private ContatoDto contato;
    private AcessoDto acesso;


    public ClienteDto() {

    }
}
