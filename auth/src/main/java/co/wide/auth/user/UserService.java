package co.wide.auth.user;

import co.wide.auth.authenticate.AuthenticateUserRequest;

import java.util.function.Supplier;

public interface UserService {

    UserEntity getUser(String login) throws Exception;

    void checkUser(UserEntity user,
                   AuthenticateUserRequest request,
                   Supplier<Exception> supplier) throws Exception;

}
