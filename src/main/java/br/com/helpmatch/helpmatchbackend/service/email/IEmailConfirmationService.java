package br.com.helpmatch.helpmatchbackend.service.email;

import br.com.helpmatch.helpmatchbackend.entities.Code;

public interface IEmailConfirmationService {
    void sendEmail(String recipient);
    boolean confirmCode(String email, String code);
}
