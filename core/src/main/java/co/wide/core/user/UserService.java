package co.wide.core.user;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAll();

    User getById(Long id);

}
