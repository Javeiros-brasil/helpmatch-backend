package br.com.helpmatch.helpmatchbackend.dto;


import br.com.helpmatch.helpmatchbackend.util.validation.Celular;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.Data;

@Data
public class ContatoDto {
    private Long id;
    @Celular
    private String celular;
    @NotBlank
    @Email
    private String email;
}
