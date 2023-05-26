package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.entity.User;
import br.com.helpmatch.helpmatchbackend.service.email.IEmailConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailConfirmationController {
    @Autowired
    public IEmailConfirmationService _emailConfirmationService;

    @PostMapping("/send")
    public void sendCode(){
        // aqui você deve substituir pelo e-mail do cliente/profissional
        String recipient = "steixeirajair@gmail.com";

        _emailConfirmationService.sendEmail(recipient);
    }
    @PostMapping("/confirm")
    public void confirmCode(){
        _emailConfirmationService.confirmCode();
    }
}
