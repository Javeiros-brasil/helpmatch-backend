package br.com.helpmatch.helpmatchbackend.service.email;

import br.com.helpmatch.helpmatchbackend.entity.Code;
import br.com.helpmatch.helpmatchbackend.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class EmailConfirmationService implements IEmailConfirmationService {
    @Autowired
    private CodeRepository codeRepository;
    @Autowired
    private ISendEmailService _sendEmailService;
    @Value("${email.sender}")
    private String EMAIL_SENDER;
    @Value("${email.body}")
    private String BODY;
    @Value("${email.subject}")
    private String SUBJECT;
    private static final Long EXPIRATION = 300000L;

    @Override
    public void sendEmail(String recipient) {
        Code code = codeGenerator();
        code.setEmail(recipient);

        String BODY = "Olá, tudo bem?" +
                "\nFalta pouco para validarmos seu cadastro!" +
                "\n\nCódigo de verificação de endereço de e-mail: " + code.getCodeVerification() + "." +
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

        return new Code(random.nextInt(999999 - 000000 + 1) + 000000,
                new Date(System.currentTimeMillis() + EXPIRATION));
    }
    @Override
    public boolean confirmCode(String email, int code) {
        Date date = new Date(System.currentTimeMillis());

        Code codeObj;
        try{
            codeObj = codeRepository.findByEmailAndCodeVerification(email, code);
        }catch (NullPointerException e){
            throw new NullPointerException("Código inválido!");
        }
        if (codeObj.getExpiration().before(date)) {
            return false;
        }
        return true;
    }
}
