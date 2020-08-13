package co.wide.auth.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @Getter
    @AllArgsConstructor
    private static class ErrorMessage {
        private final String message;
    }

    @ExceptionHandler({AuthenticationException.class})
    private ResponseEntity<ErrorMessage> handelAuthenticationException(AuthenticationException e) {
        return ResponseEntity.ok(new ErrorMessage("Что же ты делаешь урод!!! нельзя тебе!"));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    private ResponseEntity<ErrorMessage> handelMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.ok(new ErrorMessage("Оооойй дурак!!! обязательные поля не задал!"));
    }

    @ExceptionHandler({RegistrationException.class})
    private ResponseEntity<ErrorMessage> handelMethodArgumentNotValidException(RegistrationException e) {
        return ResponseEntity.ok(new ErrorMessage("Ужк есть такой красавец!"));
    }

}
