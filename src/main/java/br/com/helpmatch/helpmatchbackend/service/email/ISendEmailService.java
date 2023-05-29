package br.com.helpmatch.helpmatchbackend.service.email;

public interface ISendEmailService {
    boolean sendEmail(String recipient, String body, String subject);
}
