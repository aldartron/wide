package co.wide.core.user;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromEntity(UserEntity entity);

    UserEntity toEntity(User user);

    List<User> fromEntities(List<UserEntity> entities);

    List<UserEntity> toEntities(List<User> users);

}
