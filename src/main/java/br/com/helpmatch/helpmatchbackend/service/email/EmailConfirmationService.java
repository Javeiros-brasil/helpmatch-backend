package br.com.helpmatch.helpmatchbackend.service.email;

import br.com.helpmatch.helpmatchbackend.entities.Code;
import br.com.helpmatch.helpmatchbackend.repository.CodeRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

@Service
public class EmailConfirmationService implements IEmailConfirmationService {

    @Autowired
    private CodeRepository codeRepository;

    @Autowired
    private ISendEmailService _sendEmailService;

    @Value("${email.sender}")
    private String EMAIL_SENDER;

    @Value("${email.subject}")
    private String SUBJECT;

    private static final Duration EXPIRATION = Duration.ofHours(24);// 24h

    @Override
    public void sendEmail(String recipient) {
        Code code = codeGenerator();
        code.setEmail(recipient);

        String BODY = "Olá, tudo bem?" +
                "\nFalta pouco para validarmos seu cadastro!" +
                "\n\nCódigo de verificação de endereço de e-mail: " + code.getCode() + "." +
                "\n\nEste é o código de verificação solicitado para verificar seu endereço de e-mail." +
                "\nSe você precisar de ajuda adicional, entre em contato com " + EMAIL_SENDER + ".\n" +
                "\nAtenciosamente," +
                "\nEquipe Help Macth";

        if (_sendEmailService.sendEmail(recipient, BODY, SUBJECT)){
            codeRepository.save(code);
        }
    }

    private static Code codeGenerator() {
        Random random = new Random();

        return new Code(random.nextInt(999999 - 000000 + 1) + 000000+"",
                LocalDate.now().plus(EXPIRATION));
    }
    
    @Override
    public boolean confirmCode(String email, String code) {
    	
        LocalDate date = LocalDate.now();

        Code codeObj;

        try{
            codeObj = codeRepository.findByEmailAndCodeVerification(email, code);
        }catch (NullPointerException e){
            throw new NullPointerException("Código inválido!");
        }

        if (codeObj.getExpiration().isBefore(date)) {
            return false;
        }

        return true;
    }
}
