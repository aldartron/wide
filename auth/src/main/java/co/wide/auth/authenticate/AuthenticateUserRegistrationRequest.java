package co.wide.auth.authenticate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthenticateUserRegistrationRequest extends AuthenticateUserRequest {
    private static final String DEFAULT_ROLE = "PERSON";

    private String role = DEFAULT_ROLE;

}
