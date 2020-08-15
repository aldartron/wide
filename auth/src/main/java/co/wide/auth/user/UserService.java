package co.wide.auth.user;

import co.wide.auth.authenticate.AuthenticateUserRegistrationRequest;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public interface UserService {

    Optional<UserEntity> getUser(String username);

    UserEntity createUser(AuthenticateUserRegistrationRequest request);

    <T, R> void checkUser(Function<UserEntity, T> userFunction,
                          UserEntity userEntity,
                          Function<R, T> requestFunction,
                          R request,
                          Supplier<Exception> supplier) throws Exception;
}
