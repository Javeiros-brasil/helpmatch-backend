package br.com.helpmatch.helpmatchbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnderecoDto {
    private Long id;
    private String cep;
    private String logadouro;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

}