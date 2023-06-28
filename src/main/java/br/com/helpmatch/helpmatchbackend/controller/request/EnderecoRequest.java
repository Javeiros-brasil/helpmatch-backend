package br.com.helpmatch.helpmatchbackend.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnderecoRequest {
    @NotBlank
    private String cep;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String complemento;
    @NotBlank
    private String numero;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
}
