package br.com.helpmatch.helpmatchbackend.controller.response;

import lombok.Data;

@Data
public class AcessoResponse {
    private Long id;
    private String username;
    private String password;
    private boolean ativo;
    private boolean aceitouTermos;
}
