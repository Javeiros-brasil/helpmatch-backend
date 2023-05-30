package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.dto.CodeDto;
import br.com.helpmatch.helpmatchbackend.entity.Code;
import br.com.helpmatch.helpmatchbackend.service.email.IEmailConfirmationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email-confirmation")
@Validated
public class EmailConfirmationController {
    @Autowired
    public IEmailConfirmationService _emailConfirmationService;
    @PostMapping("/send")
    public void sendCode(@RequestParam @Valid @Email String email){
        _emailConfirmationService.sendEmail(email);
    }
    @PostMapping("/confirm")
    public boolean confirmCode(@RequestBody @Valid CodeDto recipient){
        return _emailConfirmationService.confirmCode(recipient.getEmail(), recipient.getCodeVerification());
    }
}
