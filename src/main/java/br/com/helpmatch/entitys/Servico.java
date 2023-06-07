package br.com.helpmatch.helpmatchbackend.entitys;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long profissionalId;
    private String nome;
    private String descricao;
    private long tempoDuracao;
    private double preco;
    private boolean ativo;
    private double precoPromocao;

    public void cadastrarServico(Servico servico){

    }
    public void editarServico(Long id){

    }
    public void buscarTodosServico(){

    }
    public void buscarServicoPorNome(String nome){

    }
    public void deletarServico(long id){

    }

}
