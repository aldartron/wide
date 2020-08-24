package co.wide.auth.user;

import co.wide.auth.authenticate.AuthenticateUserRegistrationRequest;
import co.wide.auth.authenticate.AuthenticateUserRequest;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.naming.AuthenticationException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void get_user_success() {
        var user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setUsername("Dog");
        user.setPassword("123");
        user.setRole("TESTER");

        Mockito.when(userRepository.findByUsername("Dog"))
                .thenReturn(Optional.of(user));

        var foundUser = userService.getUser("Dog").orElseGet(() -> {
            fail("что то пошло не так");
            return null;
        });

        assertEquals(foundUser.getUsername(), user.getUsername());
        assertEquals(foundUser.getPassword(), user.getPassword());
        assertEquals(foundUser.getId(), user.getId());
        assertEquals(foundUser.getRole(), user.getRole());
    }

    @Test
    public void get_user_not_found() {
        var user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setUsername("Dog");
        user.setPassword("123");
        user.setRole("TESTER");

        Mockito.when(userRepository.findByUsername("Dog"))
                .thenReturn(Optional.of(user));

        try {
            var foundUser = userService.getUser("123")
                    .orElseThrow(AuthenticationException::new);
            fail("Должно быть исключение");
        } catch (Exception e) {
            assertTrue(e instanceof AuthenticationException);
        }
    }

    @Test
    public void create_user_success() {
        var user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setUsername("Dog");
        user.setPassword("123");
        user.setRole("TESTER");

        Mockito.when(userRepository.save(ArgumentMatchers.any(UserEntity.class)))
                .thenReturn(user);

        var request = new AuthenticateUserRegistrationRequest();
        request.setUsername("Dog");
        request.setPassword("123");
        request.setRole("TESTER");

        var newUser = userService.createUser(request);

        assertEquals(newUser.getUsername(), request.getUsername());
        assertEquals(newUser.getPassword(), request.getPassword());
        assertEquals(newUser.getRole(), request.getRole());
    }

    @Test
    public void check_user_password_success() {
        var request = new AuthenticateUserRequest();
        request.setUsername("Dog");
        request.setPassword("123");

        var user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setUsername("Dog");
        user.setPassword("123");
        user.setRole("TESTER");

        try {
            userService.checkUser(UserEntity::getPassword, user,
                    AuthenticateUserRequest::getPassword, request,
                    AuthenticationException::new);
        } catch (Exception e) {
            fail("Исключения быть не должно");
        }
    }

    @Test
    public void check_user_password_failed() {
        var request = new AuthenticateUserRequest();
        request.setUsername("Dog");
        request.setPassword("123");

        var user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setUsername("Dog");
        user.setPassword("not valid");
        user.setRole("TESTER");

        try {
            userService.checkUser(UserEntity::getPassword, user,
                    AuthenticateUserRequest::getPassword, request,
                    AuthenticationException::new);

            fail("Должно быть исключение");
        } catch (Exception e) {
            assertTrue(e instanceof AuthenticationException);
        }
    }

    @Test
    public void check_user_username_success() {
        var request = new AuthenticateUserRequest();
        request.setUsername("Dog");
        request.setPassword("123");

        var user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setUsername("Dog");
        user.setPassword("123");
        user.setRole("TESTER");

        try {
            userService.checkUser(UserEntity::getUsername, user,
                    AuthenticateUserRequest::getUsername, request,
                    AuthenticationException::new);
        } catch (Exception e) {
            fail("Исключения быть не должно");
        }
    }

    @Test
    public void check_user_username_failed() {
        var request = new AuthenticateUserRequest();
        request.setUsername("Dog");
        request.setPassword("123");

        var user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setUsername("Cat");
        user.setPassword("123");
        user.setRole("TESTER");

        try {
            userService.checkUser(UserEntity::getUsername, user,
                    AuthenticateUserRequest::getUsername, request,
                    AuthenticationException::new);

            fail("Должно быть исключение");
        } catch (Exception e) {
            assertTrue(e instanceof AuthenticationException);
        }
    }

    @Test
    public void check_user_role_success() {
        var request = new AuthenticateUserRegistrationRequest();
        request.setUsername("Dog");
        request.setPassword("123");
        request.setRole("TESTER");


        var user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setUsername("Dog");
        user.setPassword("123");
        user.setRole("TESTER");

        try {
            userService.checkUser(UserEntity::getRole, user,
                    AuthenticateUserRegistrationRequest::getRole, request,
                    AuthenticationException::new);
        } catch (Exception e) {
            fail("Исключения быть не должно");
        }
    }

    @Test
    public void check_user_role_failed() {
        var request = new AuthenticateUserRegistrationRequest();
        request.setUsername("Dog");
        request.setPassword("123");
        request.setRole("TESTER");

        var user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setUsername("Cat");
        user.setPassword("123");
        user.setRole("VIP");

        try {
            userService.checkUser(UserEntity::getRole, user,
                    AuthenticateUserRegistrationRequest::getRole, request,
                    AuthenticationException::new);

            fail("Должно быть исключение");
        } catch (Exception e) {
            assertTrue(e instanceof AuthenticationException);
        }
    }

}