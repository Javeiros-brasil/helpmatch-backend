package br.com.helpmatch.helpmatchbackend.controller;

/*
@Author Rafael e Ruan
*/

import br.com.helpmatch.helpmatchbackend.dto.AcessoDto;
import br.com.helpmatch.helpmatchbackend.entities.Acesso;
import br.com.helpmatch.helpmatchbackend.service.AcessoProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login-profissional")
public class LoginProfissionalController {

    @Autowired
    private AcessoProfissionalService acessoService;
    
    @PostMapping
    public ResponseEntity<Acesso> login(@RequestBody AcessoDto acessoProfissionalDTO){
        Acesso acesso = acessoService.getAcessValidation(acessoProfissionalDTO.getUsername(), acessoProfissionalDTO.getPassword());
        return ResponseEntity.ok(acesso);
    }
}

