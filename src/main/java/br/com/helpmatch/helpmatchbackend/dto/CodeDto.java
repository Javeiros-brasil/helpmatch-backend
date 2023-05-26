package br.com.helpmatch.helpmatchbackend.dto;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class CodeDto {

    private int codeVerification;

    @Email
    private String email;
}
