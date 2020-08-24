package co.wide.auth.authenticate;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthenticateUserResponse {

    private final String token;

}
