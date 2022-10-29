package ao.martins.shoesclean.domain.exception;

public class NegocioException extends RuntimeException {
    public NegocioException(String s) {
        super(s);
    }
}