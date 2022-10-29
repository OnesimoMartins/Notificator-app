package ao.martins.shoesclean.core.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = TelefoneValidator.class)
public @interface NumeroTelefone {
    
    String message() default "Número de telefone inválido.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
