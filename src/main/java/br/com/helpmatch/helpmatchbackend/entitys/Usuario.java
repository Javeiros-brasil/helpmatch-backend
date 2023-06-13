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
    private Long contatosId;
    private Long enderecosId;
    private Long acessoId;
    @NotBlank
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Contato contato
    @NotBlank
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Endereco endereco
    @NotBlank
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Acesso acesso
}
