package br.com.helpmatch.helpmatchbackend.util.validation;

import br.com.helpmatch.helpmatchbackend.util.CelularUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CelularValidator implements ConstraintValidator<Celular, String>{
    public boolean isValid(String celular, ConstraintValidatorContext cxt) {
        return CelularUtil.isCelular(celular);
    }
}
