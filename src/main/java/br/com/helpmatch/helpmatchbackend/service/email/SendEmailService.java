package br.com.helpmatch.helpmatchbackend.service.email;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService implements ISendEmailService {

	@Value("${email.sender}")
    private String EMAIL_SENDER;

    @Value("${email.password}")
    private String EMAIL_SENDER_PASSWORD;

    @Override
    public boolean sendEmail(String recipient, String body, String subject) {
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com"); // Servidor SMTP do Gmail
            email.setSmtpPort(587); // Porta SMTP do Gmail
            email.setAuthentication(EMAIL_SENDER, EMAIL_SENDER_PASSWORD);
            email.setStartTLSEnabled(true); // Habilita STARTTLS
            email.setSSLOnConnect(true);
            email.setFrom(EMAIL_SENDER);
            email.setSubject(subject);
            email.setMsg(body);
            email.addTo(recipient);
            email.setCharset("UTF-8");
            email.send();

            return true;
        } catch (EmailException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
