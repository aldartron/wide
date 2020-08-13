package co.wide.auth.user;

import co.wide.auth.authenticate.AuthenticateUserRegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Optional<UserEntity> getUser(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public UserEntity createUser(AuthenticateUserRegistrationRequest request) {
        var userEntity = new UserEntity();

        userEntity.setLogin(request.getLogin());
        userEntity.setPassword(request.getPassword());
        userEntity.setRole(request.getRole());

        return repository.save(userEntity);
    }

    @Override
    public <T, R> void checkUser(Function<UserEntity, T> userFunction,
                                 UserEntity userEntity,
                                 Function<R, T> requestFunction,
                                 R request,
                                 Supplier<Exception> supplier) throws Exception {

        if (!userFunction.apply(userEntity).equals(requestFunction.apply(request))) {
            throw supplier.get();
        }
    }

}
