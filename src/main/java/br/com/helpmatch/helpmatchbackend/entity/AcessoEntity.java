package br.com.helpmatch.helpmatchbackend.entity;

import lombok.Data;

@Data
public class AcessoEntity {
    private Long id;
    private String username;
    private String password;
    private boolean ativo;
    private boolean aceitouTermos;
}
