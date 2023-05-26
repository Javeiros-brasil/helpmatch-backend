package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.dto.CodeDto;
import br.com.helpmatch.helpmatchbackend.entity.Code;
import br.com.helpmatch.helpmatchbackend.service.email.IEmailConfirmationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "email-confirmation/")
public class EmailConfirmationController {
    @Autowired
    public IEmailConfirmationService _emailConfirmationService;

    @PostMapping("/send")
    public void sendCode(@RequestBody @Valid CodeDto recipient){

        _emailConfirmationService.sendEmail(recipient.getEmail());
    }
    @PostMapping("/confirm")
    public boolean confirmCode(@RequestBody @Valid CodeDto recipient){

        return _emailConfirmationService.confirmCode(recipient.getEmail(), recipient.getCodeVerification());
    }
}
