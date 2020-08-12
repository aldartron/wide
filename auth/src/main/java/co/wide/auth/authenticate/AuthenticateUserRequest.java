package co.wide.auth.authenticate;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AuthenticateUserRequest {

    @NotBlank
    private String login;
    @NotBlank
    private String password;

}