package co.wide.auth.authenticate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
public interface AuthenticateApi {

    @PostMapping("/login")
    ResponseEntity<AuthenticateUserResponse> login(@RequestBody AuthenticateUserRequest request) throws Exception;

}
