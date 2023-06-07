package br.com.helpmatch.helpmatchbackend.entitys;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Cliente extends Usuario {
    @NotNull
    @OneToMany()
    private List<Agendamento> agendamentos;

    public void avaliarAtendimento(){

    }


}
