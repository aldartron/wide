package co.wide.core.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
public interface UserApi {

    @PostMapping
    User createUser(@RequestBody User user);

    @GetMapping
    List<User> getUsers();

    @GetMapping("/{id}")
    User getUser(@PathVariable Long id);

}
