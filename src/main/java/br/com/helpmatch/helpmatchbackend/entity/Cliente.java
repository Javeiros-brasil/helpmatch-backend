package br.com.helpmatch.helpmatchbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_Completo;
    private  String cpf;
    private Date data_Nascimento;
    private String nome_Mae;
    private String nome_Pai;
    private Long contatosid;
    private Long enderecosid;
    private Long acessoid;

    public Cliente(Long id, String nome_Completo, String cpf, Date data_Nascimento,
                   String nome_Mae, String nome_Pai, Long contatosid, Long enderecosid, Long acessoid) {
        this.id = id;
        this.nome_Completo = nome_Completo;
        this.cpf = cpf;
        this.data_Nascimento = data_Nascimento;
        this.nome_Mae = nome_Mae;
        this.nome_Pai = nome_Pai;
        this.contatosid = contatosid;
        this.enderecosid = enderecosid;
        this.acessoid = acessoid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_Completo() {
        return nome_Completo;
    }

    public void setNome_Completo(String nome_Completo) {
        this.nome_Completo = nome_Completo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_Nascimento() {
        return data_Nascimento;
    }

    public void setData_Nascimento(Date data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }

    public String getNome_Mae() {
        return nome_Mae;
    }

    public void setNome_Mae(String nome_Mae) {
        this.nome_Mae = nome_Mae;
    }

    public String getNome_Pai() {
        return nome_Pai;
    }

    public void setNome_Pai(String nome_Pai) {
        this.nome_Pai = nome_Pai;
    }

    public Long getContatosid() {
        return contatosid;
    }

    public void setContatosid(Long contatosid) {
        this.contatosid = contatosid;
    }

    public Long getEnderecosid() {
        return enderecosid;
    }

    public void setEnderecosid(Long enderecosid) {
        this.enderecosid = enderecosid;
    }

    public Long getAcessoid() {
        return acessoid;
    }

    public void setAcessoid(Long acessoid) {
        this.acessoid = acessoid;
    }
}
