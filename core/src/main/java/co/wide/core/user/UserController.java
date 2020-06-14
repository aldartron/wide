package co.wide.core.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService userService;

    @Override
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userService.getAll();
    }

    @Override
    public User getUser(Long id) {
        return userService.getById(id);
    }
}
