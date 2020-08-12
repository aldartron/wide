package co.wide.auth.authenticate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api/auth")
public interface AuthenticateApi {

    @PostMapping("/login")
    ResponseEntity<AuthenticateUserResponse> login(
            @RequestBody @Valid AuthenticateUserRequest request) throws Exception;

}
