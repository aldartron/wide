package co.wide.auth.authenticate;

import co.wide.auth.common.JwtUtil;
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
    public ResponseEntity<AuthenticateUserResponse> login(AuthenticateUserRequest request) throws Exception {
        UserEntity user = userService.getUser(request.getLogin());
        userService.checkUser(user, request, AuthenticationException::new);

        AuthenticateUserResponse response = new AuthenticateUserResponse();
        response.setToken(jwtUtil.generateTokenByUser(user));

        return ResponseEntity.ok(response);
    }

}
