package br.com.helpmatch.helpmatchbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AcessoDto {

    private Long id;
    private String username;
    private String password;
    private Boolean ativo;
    private Boolean aceitouTermos;

}