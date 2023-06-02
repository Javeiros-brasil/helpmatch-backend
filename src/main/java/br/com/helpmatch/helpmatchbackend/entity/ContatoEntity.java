package br.com.helpmatch.helpmatchbackend.entity;

import lombok.Data;

@Data
public class ContatoEntity {
    private Long id;
    private String celular;
    private String email;
}
