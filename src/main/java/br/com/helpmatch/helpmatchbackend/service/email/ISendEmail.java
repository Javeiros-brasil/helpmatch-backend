package br.com.helpmatch.helpmatchbackend.service.email;

public interface ISendEmail {

    boolean sendEmail(String recipient, String body, String subject);
}
