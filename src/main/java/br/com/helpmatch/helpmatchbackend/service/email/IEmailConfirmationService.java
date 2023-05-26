package br.com.helpmatch.helpmatchbackend.service.email;

public interface IEmailConfirmationService {
    void sendEmail(String recipient);

    void confirmCode();
}
