package br.com.helpmatch.helpmatchbackend.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Profissional extends Usuario{

    @NotNull
    @OneToMany
    private List<Servico> servicos;

    public void iniciarAtendimento(){

    }
}
