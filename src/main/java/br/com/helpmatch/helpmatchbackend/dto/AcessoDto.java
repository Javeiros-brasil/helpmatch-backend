package br.com.helpmatch.helpmatchbackend.dto;

import jakarta.validation.constraints.NotBlank;

/*
@Author Rafael e Ruan
*/

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcessoDto{
    private long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private boolean ativo;
    private boolean aceitouTermos;
}
