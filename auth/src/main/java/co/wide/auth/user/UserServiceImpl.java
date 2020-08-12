package co.wide.auth.user;

import co.wide.auth.authenticate.AuthenticateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserEntity getUser(String login) throws Exception {
        return repository.findByLogin(login)
                .orElseThrow(AuthenticationException::new);
    }

    @Override
    public void checkUser(UserEntity userEntity,
                          AuthenticateUserRequest request,
                          Supplier<Exception> supplier) throws Exception {
        //TODO расшифровка пароля

        if (!userEntity.getPassword().equals(request.getPassword())) {
            throw supplier.get();
        }
    }

}
