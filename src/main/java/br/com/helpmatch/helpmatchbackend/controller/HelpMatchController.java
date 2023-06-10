package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.entities.Acesso;
import br.com.helpmatch.helpmatchbackend.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelpMatchController {

    @Autowired
    private AcessoService acessoService;

    @PostMapping
    public ResponseEntity<Acesso> login(@RequestBody String username, @RequestBody String password) {
        Acesso acesso = acessoService.getAcessValidation(username, password);
        return ResponseEntity.ok(acesso);
    }
}
