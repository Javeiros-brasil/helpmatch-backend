package br.com.helpmatch.helpmatchbackend.entitys;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;
    private long profissionalId;
    private String nome;
    private String descricao;
    private long tempoDuracao;
    private double preco;
    private boolean ativo;
    private double precoPromocao;
    @NotNull
    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos;

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
