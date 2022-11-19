package ao.martins.shoesclean.domain.exception;

import lombok.Getter;


public class NumeroTelefoneJaEmUsoException extends NegocioException {
    public NumeroTelefoneJaEmUsoException(String s) {
        super(s);
    }
}
