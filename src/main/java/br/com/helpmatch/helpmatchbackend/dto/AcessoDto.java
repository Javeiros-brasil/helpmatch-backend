package br.com.helpmatch.helpmatchbackend.dto;

import lombok.Data;

@Data
public class AcessoDto {
    private Long id;
    private String username;
    private String password;
    private boolean ativo;
    private boolean aceitouTermos;
}
