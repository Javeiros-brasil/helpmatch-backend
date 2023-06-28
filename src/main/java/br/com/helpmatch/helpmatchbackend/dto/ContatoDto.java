package br.com.helpmatch.helpmatchbackend.dto;


import lombok.Data;

@Data
public class ContatoDto {
    private Long id;
    private String celular;
    private String email;
}
