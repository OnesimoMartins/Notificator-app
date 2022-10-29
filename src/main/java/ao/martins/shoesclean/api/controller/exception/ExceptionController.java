package ao.martins.shoesclean.api.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ao.martins.shoesclean.api.dto.response.ErrorResponse;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
       
        var problem=ErrorResponse.builder()
        .status(400)
        .details("Um ou mais campos estão inválidos")
        .tittle("Erro no corpo da requesição")
        .build();

        return this.handleExceptionInternal(ex, problem, headers, status, request) 
        ;
    }

    // @Override
    // protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
    //         HttpStatus status, WebRequest request) {
     
    //     body=ErrorResponse.builder().status(status.value()).

    //     return super.handleExceptionInternal(ex, body, headers, status, request);
    // }
}
