package co.wide.auth.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler
    private ResponseEntity<String> handelAuthenticationException(AuthenticationException e) {
        return ResponseEntity.ok("Что же ты делаешь урод!!! нельзя тебе!");
    }

}
