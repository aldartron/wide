package co.wide.core.user;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getById(Long id);

    List<User> getAll();

    List<User> getByPlan(Long planId);

}
