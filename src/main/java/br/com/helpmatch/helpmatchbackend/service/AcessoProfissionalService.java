package br.com.helpmatch.helpmatchbackend.service;

/*
@Author Rafael e Ruan
*/

import br.com.helpmatch.helpmatchbackend.entities.Acesso;
import io.micrometer.common.util.StringUtils;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.helpmatch.helpmatchbackend.repository.AcessoProfissionalRepository;

@Service
public class AcessoProfissionalService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AcessoProfissionalService.class);
    @Autowired
    private AcessoProfissionalRepository acessoRepository;
    
    public Acesso getAcessValidation(String username, String password) throws RuntimeException{
        validateValues(username, password);
        Optional<Acesso> optionalAcessoUsername = acessoRepository.findByUsername(username);
        if(optionalAcessoUsername.isPresent()){
            Acesso acesso = optionalAcessoUsername.get();
            validateParmitionAcessAccount(acesso);
            if(!acesso.getPassword().equals(password)){
                LOGGER.info("Senha Inválida");
                throw new RuntimeException("Senha Inválida");
            }else{
                return acesso;
            }
        }
        return null;
    }
    
    public void validateParmitionAcessAccount(Acesso acesso){
        if(!acesso.isAtivo() && !acesso.isAceitouTermos()){
            LOGGER.info("Conta inativa e Termos não Aceitos");
            throw new RuntimeException("Conta inativa e Termos não Aceitos");
        }else if(!acesso.isAtivo()){
            LOGGER.info("Profissional Inativo");
            throw new RuntimeException("Profissional Inativo");
        }else if(!acesso.isAceitouTermos()){
            LOGGER.info("Termos não Aceitos");
            throw new RuntimeException("Termos não Aceitos");
        }
    }
    
    public void validateValues(String username, String password) throws RuntimeException{
        if(StringUtils.isBlank(username) && StringUtils.isBlank(password)){
            LOGGER.info("Usuário e Password Vazios");
            throw new RuntimeException("Usuário e Password Vazios");
        }else if(StringUtils.isBlank(username)){
            LOGGER.info("Username Vazio");
            throw new RuntimeException("Username Vazio");
        }else if(StringUtils.isBlank(password)){
            LOGGER.info("Password Vazio");
            throw new RuntimeException("Password Vazio");
        }
    }
}