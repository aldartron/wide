package co.wide.auth.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RegistrationException extends RuntimeException {

    public RegistrationException(String e) {
        super(e);
    }
}
