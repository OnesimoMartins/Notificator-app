package ao.martins.shoesclean.core.validation;

import ao.martins.shoesclean.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<NumeroTelefone,String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    return  ValidationUtils.isNumeroTelefone(value) ;
    }
    
}
