package co.wide.auth.authenticate;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class AuthenticateUserResponse {

    private String token;

}
