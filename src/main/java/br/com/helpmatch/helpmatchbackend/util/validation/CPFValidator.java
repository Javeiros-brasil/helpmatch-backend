package br.com.helpmatch.helpmatchbackend.util.validation;

import br.com.helpmatch.helpmatchbackend.util.CPFUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFValidator implements ConstraintValidator<CPF, String> {
    public boolean isValid(String cpf, ConstraintValidatorContext cxt) {
        return CPFUtil.isCPF(cpf);
    }
}
