package br.com.helpmatch.helpmatchbackend.util.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CPFValidator.class)
public @interface CPF {
    public String message() default "Celular Incorreto";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
