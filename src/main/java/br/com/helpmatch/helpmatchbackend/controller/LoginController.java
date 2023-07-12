package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.dto.AcessoDTO;
import br.com.helpmatch.helpmatchbackend.entities.Acesso;
import br.com.helpmatch.helpmatchbackend.service.AcessoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AcessoService acessoService;

    @PostMapping
    public ResponseEntity<Acesso> login(@RequestBody AcessoDTO acessoDTO) {
        Acesso acesso = acessoService.getAcessValidation(acessoDTO);
        if (acesso == null){
            LOGGER.info("Nao foi possível seguir com o login");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(acesso);
    }
}
