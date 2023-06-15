package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.dto.AcessoProfissionalDTO;
import br.com.helpmatch.helpmatchbackend.entities.Acesso;
import br.com.helpmatch.helpmatchbackend.service.AcessoProfissionalService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AcessoProfissionalController {
    @Autowired
    private AcessoProfissionalService acessoService;
    
    @PostMapping
    public ResponseEntity<Acesso> login(@RequestBody AcessoProfissionalDTO acessoProfissionalDTO){
        Acesso acesso = acessoService.getAcessValidation(acessoProfissionalDTO.getUsername(), acessoProfissionalDTO.getPassword());
        return ResponseEntity.ok(acesso);
    }
    
    @GetMapping
    public ResponseEntity<Map<String, String>> getUserCredentials(){
        String username = "teste";
        String password = "123456";
        
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", username);
        credentials.put("password", password);
        
        return ResponseEntity.ok(credentials);

    }
}

