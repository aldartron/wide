package co.wide.auth.authenticate;

import co.wide.auth.common.JwtUtil;
import co.wide.auth.exception.RegistrationException;
import co.wide.auth.user.UserService;
import co.wide.auth.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequiredArgsConstructor
public class AuthenticateController implements AuthenticateApi {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Override
    public ResponseEntity<AuthenticateUserResponse> login(
            AuthenticateUserRequest request) throws Exception {

        var user = userService.getUser(request.getUsername())
                .orElseThrow(AuthenticationException::new);

        userService.checkUser(UserEntity::getPassword, user,
                AuthenticateUserRequest::getPassword, request,
                AuthenticationException::new);

        return ResponseEntity.ok(AuthenticateUserResponse.builder()
                .token(jwtUtil.generateTokenByUser(user))
                .build());
    }

    @Override
    public ResponseEntity<AuthenticateUserResponse> registration(
            AuthenticateUserRegistrationRequest request) {

        var user = userService.getUser(request.getUsername());

        if (user.isPresent()) {
            throw new RegistrationException();
        }

        var newUser = userService.createUser(request);

        return ResponseEntity.ok(AuthenticateUserResponse.builder()
                .token(jwtUtil.generateTokenByUser(newUser))
                .build());
    }

}
