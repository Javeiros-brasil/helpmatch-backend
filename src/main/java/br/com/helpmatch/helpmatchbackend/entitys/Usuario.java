package br.com.helpmatch.helpmatchbackend.entitys;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private Date dataNascimento;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String cpf;
    @NotBlank
    private String nomePai;
    @NotBlank
    private String nomeMae;
    @NotBlank
    private Long contatosId;
    @NotBlank
    private Long enderecosId;
    @NotBlank
    private Long acessoId;
}
