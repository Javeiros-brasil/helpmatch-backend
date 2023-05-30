package br.com.helpmatch.helpmatchbackend.dto;

import java.util.Date;

import br.com.helpmatch.helpmatchbackend.entity.ProfissionalEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfissionalDto {
    private Long id;
    private String nome_completo; 
    private String cpf;
    private Date dataNascimento;
    private String nomeMae;
    private String nomePai;
    private Long contatoId;
    private Long enderecoId;
    private Long acessoId;
    private ContatoDto contato;
    
    public ProfissionalDto(ProfissionalEntity profissional) {
    	this.id = profissional.getId();
    	this.nome_completo = profissional.getNome_completo();
    	this.cpf = profissional.getCpf();
    	this.dataNascimento = profissional.getDataNascimento();
    	this.nomeMae = profissional.getNomeMae();
    	this.nomePai = profissional.getNomePai();
    	this.contatoId = profissional.getContatoId();
    	this.enderecoId = profissional.getEnderecoId();
    	this.acessoId = profissional.getAcessoId();
    	this.contato = profissional.getContato();
    }
    
}
