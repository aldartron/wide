package co.wide.auth.authenticate;

import lombok.Data;

@Data
public class AuthenticateUserRequest {

    private String login;
    private String password;

}