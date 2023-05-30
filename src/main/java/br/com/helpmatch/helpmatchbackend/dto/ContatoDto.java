package br.com.helpmatch.helpmatchbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContatoDto {
 private long id;
 private String celular;
 private String email;
 
}
