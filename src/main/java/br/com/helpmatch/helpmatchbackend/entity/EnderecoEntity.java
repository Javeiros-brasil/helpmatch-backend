package br.com.helpmatch.helpmatchbackend.entity;

import lombok.Data;

@Data
public class EnderecoEntity {
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
}
