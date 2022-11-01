package ao.martins.shoesclean.core.validation;

import ao.martins.shoesclean.api.dto.input.FuncionarioInput;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumeroTelefoneNaoRegistradoValidator.class)
public @interface NumeroTelefoneNaoRegistrado {

    String message() default "Número de telefone já registrado.";

    Class<?>[] groups() default {  };

    Class<? extends Payload>[] payload() default { };


}
