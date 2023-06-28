package br.com.helpmatch.helpmatchbackend.controller.response;

import lombok.Data;

@Data
public class EnderecoResponse {
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
}
