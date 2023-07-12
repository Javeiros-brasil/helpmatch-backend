package br.com.helpmatch.helpmatchbackend.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CodeDto {
    @Min(value = 6, message = "Código inválido.")
    private String code;
    
    @Email(message = "Deve ser um email válido.")
    private String email;
}
