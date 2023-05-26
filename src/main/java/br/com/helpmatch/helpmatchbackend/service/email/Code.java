package br.com.helpmatch.helpmatchbackend.service.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@AllArgsConstructor
public class Code {
    private int code;

    private Date expiration;

}
