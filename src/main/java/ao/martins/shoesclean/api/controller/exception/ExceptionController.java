package ao.martins.shoesclean.api.controller.exception;

import ao.martins.shoesclean.domain.exception.NumeroTelefoneJaEmUsoException;
import ao.martins.shoesclean.domain.exception.OperacaoNaoPermitidaException;
import ao.martins.shoesclean.domain.exception.PalavraPasseIncorrectaExepion;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ao.martins.shoesclean.api.dto.response.ErrorResponse;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        var problem=ErrorResponse.builder()
        .status(400)
                .code("A-01")
        .details("Um ou mais campos estão inválidos.")
        .tittle("Erro no corpo da requesição")
        .build();

        return this.handleExceptionInternal(ex, problem, headers, status, request);
    }
    @ExceptionHandler(NumeroTelefoneJaEmUsoException.class)
    protected ResponseEntity<Object> handleNumeroTelefoneJaEmUsoException(NumeroTelefoneJaEmUsoException ex,
                                           WebRequest request) {
        var problem=ErrorResponse.builder()
                .status(400)
                .code("A-02")
                .details("O número fornecido ja está a ser utilizado por outro funcionário.")
                .tittle("Número de telefone em uso")
                .build();

        return this.handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    @ExceptionHandler(OperacaoNaoPermitidaException.class)
    protected ResponseEntity<Object> handleOperacaoNaoPermitidaException(OperacaoNaoPermitidaException ex,
                                                                          WebRequest request) {
        var problem=ErrorResponse.builder()
                .status(400)
                .code("C-00")
                .details(ex.getMessage())
                .tittle("Operação não permitida")
                .build();

        return this.handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex,
                                                                         WebRequest request) {
        var problem=ErrorResponse.builder()
                .status(404)
                .code("C-01")
                .details(ex.getMessage())
                .tittle("Entidade não encontrada")
                .build();

        return this.handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.valueOf(404), request);
    }
    @ExceptionHandler(PalavraPasseIncorrectaExepion.class)
    protected ResponseEntity<Object> handlePalavraPasseIncorrectaExepion(PalavraPasseIncorrectaExepion ex,
                                                                          WebRequest request) {
        var problem=ErrorResponse.builder()
                .status(400)
                .code("C-00")
                .details("A palavra passe incorrecta está incorrecta.")
                .tittle("Palavra-passe incorrecta")
                .build();

        return this.handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
//    @ExceptionHandler(NegocioException.class)
//    protected ResponseEntity<Object> handleNegocioException(NegocioException ex,
//                                                                         WebRequest request) {
//        var problem=ErrorResponse.builder()
//                .status(500)
//                .code("A-00")
//                .details("A palavra passe incorrecta está incorrecta.")
//                .tittle("Impossível ")
//                .build();
//
//        return this.handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
//    }

    // @Override
    // protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
    //         HttpStatus status, WebRequest request) {
    //     body=ErrorResponse.builder().status(status.value()).
    //     return super.handleExceptionInternal(ex, body, headers, status, request);
    // }

}
