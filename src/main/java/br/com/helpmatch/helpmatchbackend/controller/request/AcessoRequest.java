package br.com.helpmatch.helpmatchbackend.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AcessoRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private boolean ativo;
    private boolean aceitouTermos;
}
