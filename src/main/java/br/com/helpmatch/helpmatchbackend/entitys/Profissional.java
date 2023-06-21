package br.com.helpmatch.helpmatchbackend.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profissional {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date dataNascimento;
    private String nomeCompleto;
    private String cpf;
    private String nomePai;
    private String nomeMae;
    private Long contatosId;
    private Endereco enderecos;
    private Long acessoId;
    @OneToMany
    private List<Servico> servicos;



    public void iniciarAtendimento(){

    }


}