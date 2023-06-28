package br.com.helpmatch.helpmatchbackend.controller.request;


import br.com.helpmatch.helpmatchbackend.util.validation.Celular;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ContatoRequest {
    @Celular
    private String celular;
    @NotBlank
    @Email
    private String email;
}
