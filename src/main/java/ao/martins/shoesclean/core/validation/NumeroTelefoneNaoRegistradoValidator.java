package ao.martins.shoesclean.core.validation;

import ao.martins.shoesclean.domain.exception.NumeroTelefoneJaEmUsoException;
import ao.martins.shoesclean.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumeroTelefoneNaoRegistradoValidator implements ConstraintValidator<NumeroTelefoneNaoRegistrado,String> {

    @Autowired
    private FuncionarioService funcionarioService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(funcionarioService.getFuncionarioByTelefoneOrNull(value)!=null)
            throw new NumeroTelefoneJaEmUsoException("""
   Este número de telefone '%s' já esta a ser utilizado por outro funcionário.""".formatted(value));
 return  true;
//        return funcionarioService.getFuncionarioByTelefoneOrNull(value)==null;
    }
}
