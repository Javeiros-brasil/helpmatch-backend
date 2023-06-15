package br.com.helpmatch.helpmatchbackend.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author Rafael e Ruan
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcessoProfissionalDTO{
    private long id;
    private String username;
    private String password;
    private boolean ativo;
    private boolean aceitouTermos;
   
}
