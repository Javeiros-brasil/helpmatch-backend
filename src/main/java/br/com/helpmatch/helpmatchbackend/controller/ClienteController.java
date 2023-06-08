package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.dto.ClienteDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @PostMapping
    public void criarconta() {
        ClienteDto cliente = new ClienteDto();
    }
}



