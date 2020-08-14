package co.wide.auth.authenticate;

import co.wide.auth.common.JwtUtil;
import co.wide.auth.exception.RegistrationException;
import co.wide.auth.user.UserService;
import co.wide.auth.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthenticateController implements AuthenticateApi {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Override
    public ResponseEntity<AuthenticateUserResponse> login(AuthenticateUserRequest request) throws Exception {
        var user = userService.getUser(request.getLogin())
                .orElseThrow(AuthenticationException::new);

        userService.checkUser(UserEntity::getPassword, user,
                AuthenticateUserRequest::getPassword, request,
                AuthenticationException::new);

        var response = new AuthenticateUserResponse();
        response.setToken(jwtUtil.generateTokenByUser(user));

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<AuthenticateUserResponse> registration(@Valid AuthenticateUserRegistrationRequest request) throws Exception {
        Optional<UserEntity> user = userService.getUser(request.getLogin());

        if (user.isPresent()) {
            throw new RegistrationException();
        }

        var newUser = userService.createUser(request);
        var response = new AuthenticateUserResponse();

        response.setToken(jwtUtil.generateTokenByUser(newUser));

        return ResponseEntity.ok(response);
    }

}
