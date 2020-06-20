package co.wide.core.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User createUser(User user) {
        var saved = userRepository.save(
                userMapper.toEntity(user)
        );
        return userMapper.fromEntity(saved);
    }

    @Override
    public User getById(Long id) {
        return userMapper.fromEntity(
                userRepository.getOne(id)
        );
    }

    @Override
    public List<User> getAll() {
        return userMapper.fromEntities(
                userRepository.findAll()
        );
    }

    @Override
    public List<User> getByPlan(Long planId) {
        return null;
    }
}
