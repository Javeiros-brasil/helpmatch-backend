package br.com.helpmatch.helpmatchbackend.service;

import br.com.helpmatch.helpmatchbackend.entities.Acesso;
import br.com.helpmatch.helpmatchbackend.repository.AcessoRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AcessoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AcessoService.class);
    @Autowired
    private AcessoRepository acessoRepository;

    /*como aqui está sendo testado apenas superficial para validar o acesso do cliente
    esta sendo buscado na base pelo nome do usuário apenas.*/
    public Acesso getAcessValidation(String username, String password) throws RuntimeException {
        validateValues(username, password);
        Optional<Acesso> optionalAcessoUsername = acessoRepository.findByUsername(username);
        if (optionalAcessoUsername.isPresent()) {
            Acesso acesso = optionalAcessoUsername.get();
            validatePermitionAcessAccount(acesso);
            if (!acesso.getPassword().equals(password)) {
                LOGGER.info("A senha digitada está errada");
                throw new RuntimeException("A senha digitada está errada");
            } else {
                return acesso;
            }
        }
        return null;
    }

    private void validatePermitionAcessAccount(Acesso acesso) {
        if (!acesso.isAtivo() && !acesso.isAceitouTermos()) {
            LOGGER.info("Cliente não possui conta ativa nem aceitou os termos");
            throw new RuntimeException("Cliente não possui conta ativa nem aceitou os termos");
        }
        if (!acesso.isAtivo()) {
            LOGGER.info("Cliente não possui conta ativa");
            throw new RuntimeException("Cliente não possui conta ativa");
        }
        if (!acesso.isAceitouTermos()) {
            LOGGER.info("Cliente não aceitou os termos");
            throw new RuntimeException("Cliente não aceitou os termos");
        }
    }

    private void validateValues(String username, String password) throws RuntimeException {
        if (StringUtils.isBlank(username)) {
            LOGGER.info("Username não está preenchido");
            throw new RuntimeException("Username não está preenchido");
        }
        if (StringUtils.isBlank(password)) {
            LOGGER.info("Password não está preenchido");
            throw new RuntimeException("Password não está preenchido");
        }
        if (StringUtils.isBlank(username) && StringUtils.isBlank(password)) {
            LOGGER.info("Usuario e Password não estão preenchidos");
            throw new RuntimeException("Usuario e Password não está preenchido");
        }
    }
}
