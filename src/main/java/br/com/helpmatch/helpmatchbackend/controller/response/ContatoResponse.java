package br.com.helpmatch.helpmatchbackend.controller.response;

import lombok.Data;

@Data
public class ContatoResponse {
    private Long id;
    private String celular;
    private String email;
}
