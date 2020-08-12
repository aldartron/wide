package co.wide.auth.user;

import co.wide.auth.authenticate.AuthenticateUserRequest;
import org.junit.jupiter.api.Test;
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
    public void get_user_success() throws Exception {
        UserEntity user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setLogin("Dog");
        user.setPassword("123");
        user.setRole("TESTER");

        Mockito.when(userRepository.findByLogin("Dog"))
                .thenReturn(Optional.of(user));

        UserEntity foundUser = userService.getUser("Dog");

        assertEquals(foundUser.getLogin(), user.getLogin());
        assertEquals(foundUser.getPassword(), user.getPassword());
        assertEquals(foundUser.getId(), user.getId());
        assertEquals(foundUser.getRole(), user.getRole());
    }

    @Test
    public void get_user_not_found() {
        UserEntity user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setLogin("Dog");
        user.setPassword("123");
        user.setRole("TESTER");

        Mockito.when(userRepository.findByLogin("Dog"))
                .thenReturn(Optional.of(user));

        try {
            UserEntity foundUser = userService.getUser("123");
            fail("Должно быть исключение");
        } catch (Exception e) {
            assertTrue(e instanceof AuthenticationException);
        }
    }

    @Test
    public void check_user_success() {
        AuthenticateUserRequest request = new AuthenticateUserRequest();
        request.setLogin("Dog");
        request.setPassword("123");

        UserEntity user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setLogin("Dog");
        user.setPassword("123");
        user.setRole("TESTER");

        try {
            userService.checkUser(user, request, AuthenticationException::new);
        } catch (Exception e) {
            fail("Исулючения быть не должно");
        }
    }

    @Test
    public void check_user_failed() {
        AuthenticateUserRequest request = new AuthenticateUserRequest();
        request.setLogin("Dog");
        request.setPassword("123");

        UserEntity user = new UserEntity();
        user.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        user.setLogin("Dog");
        user.setPassword("not valid");
        user.setRole("TESTER");

        try {
            userService.checkUser(user, request, AuthenticationException::new);
            fail("Должно быть исключение");
        } catch (Exception e) {
            assertTrue(e instanceof AuthenticationException);
        }
    }

}