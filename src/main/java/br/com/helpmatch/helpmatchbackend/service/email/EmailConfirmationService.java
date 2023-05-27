package br.com.helpmatch.helpmatchbackend.service.email;

import br.com.helpmatch.helpmatchbackend.entity.Code;
import br.com.helpmatch.helpmatchbackend.repository.CodeRepository;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class EmailConfirmationService implements IEmailConfirmationService {

    private final CodeRepository codeRepository;

    public EmailConfirmationService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Override
    public void sendEmail(String recipient) {
        Code code = codeGenerator();
        code.setEmail(recipient);

        String emailSender = "helpmatchapp@gmail.com";
        String emailSenderPassword = "dtuilyswyudssver";

        String subject = "Código de Verificação";

        String body = "Olá, tudo bem?" +
                "\nFalta pouco para validarmos seu cadastro!" +
                "\n\nCódigo de verificação de endereço de e-mail: " + code.getCodeVerification() + "." +
                "\n\nEste é o código de verificação solicitado para verificar seu endereço de e-mail." +
                "\nSe você precisar de ajuda adicional, entre em contato com " + emailSender + ".\n" +
                "\nAtenciosamente," +
                "\nEquipe Help Macth";


        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com"); // Servidor SMTP do Gmail
            email.setSmtpPort(587); // Porta SMTP do Gmail
            email.setAuthentication(emailSender, emailSenderPassword);
            email.setStartTLSEnabled(true); // Habilita STARTTLS
            email.setSSLOnConnect(true);
            email.setFrom(emailSender);
            email.setSubject(subject);
            email.setMsg(body);
            email.addTo(recipient);

            email.send();
            codeRepository.save(code);
        } catch (EmailException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static Code codeGenerator() {
        Long expiration = 300000L;
        Random random = new Random();

        return new Code(random.nextInt((999999 - 000000) + 1) + 000000,
                new Date(System.currentTimeMillis() + expiration));
    }

    @Override
    public boolean confirmCode(String email, int code) {

        Date date = new Date(System.currentTimeMillis());
        Code codeObj = codeRepository.findByEmailAndCodeVerification(email, code);

        if (codeObj.getExpiration().before(date)) {
            return false;
        }
        return true;
    }
}
