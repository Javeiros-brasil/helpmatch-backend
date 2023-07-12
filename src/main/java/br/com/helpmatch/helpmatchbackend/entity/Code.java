package br.com.helpmatch.helpmatchbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int codeVerification;
    private Date expiration;
    private String email;
    public Code(int codeVerification, Date expiration) {
        this.codeVerification = codeVerification;
        this.expiration = expiration;
    }
}
