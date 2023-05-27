package br.com.helpmatch.helpmatchbackend.service.email;

import br.com.helpmatch.helpmatchbackend.entity.Code;

public interface IEmailConfirmationService {
    void sendEmail(String recipient);

    boolean confirmCode(String email, int code);
}
