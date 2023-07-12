package br.com.helpmatch.helpmatchbackend.dto;

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
    private String username;
    private String password;
    private boolean ativo;
    private boolean aceitouTermos;
   
}
