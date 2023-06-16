package br.com.helpmatch.helpmatchbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
/**
 *
 * @author Rafael
 */

@Entity
public class Profissional {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeSocial;
    private String nomeFantasia;
    private String documento;
    private Date dataNascimento;
    private Date fundacaoEmpresa;
    private String enderecoCidade;
    private String enderecoRua;
    private String enderecoBairro;
    private String enderecoCep;
    private int enderecoNumero;
    private String tipoDocumento;
    private String celular;
    private String email;
    
    public Profissional(){
    }

    public Profissional(Long id, String nomeSocial, 
            String nomeFantasia, String documento, Date dataNascimento, 
            Date fundacaoEmpresa, String enderecoCidade, String enderecoRua, 
            String enderecoBairro, String enderecoCep, int enderecoNumero, String 
                    tipoDocumento, String celular, String email) {
        
        this.id = id;
        this.nomeSocial = nomeSocial;
        this.nomeFantasia = nomeFantasia;
        this.documento = documento;
        this.dataNascimento = dataNascimento;
        this.fundacaoEmpresa = fundacaoEmpresa;
        this.enderecoCidade = enderecoCidade;
        this.enderecoRua = enderecoRua;
        this.enderecoBairro = enderecoBairro;
        this.enderecoCep = enderecoCep;
        this.enderecoNumero = enderecoNumero;
        this.tipoDocumento = tipoDocumento;
        this.celular = celular;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getFundacaoEmpresa() {
        return fundacaoEmpresa;
    }

    public void setFundacaoEmpresa(Date fundacaoEmpresa) {
        this.fundacaoEmpresa = fundacaoEmpresa;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public String getEnderecoRua() {
        return enderecoRua;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public int getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(int enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
        
}
