package br.com.helpmatch.helpmatchbackend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Cliente extends Usuario {
	
	@Column(nullable = false)
    private String nomeCompleto;
    
    @Column(nullable = false)
    private String cpf;
    
    @Column(nullable = false)
    private String nomePai;
    
    @Column(nullable = false)
    private String nomeMae;
    
    @Column(nullable = false)
    private LocalDate dataNascimento;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos;

}
