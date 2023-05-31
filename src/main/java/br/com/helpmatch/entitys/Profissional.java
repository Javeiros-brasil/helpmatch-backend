package br.com.helpmatch.helpmatchbackend.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profissional {
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
    @NotNull
    @OneToMany
    private List<Servico> servicos;



    public void iniciarAtendimento(){

    }


}
