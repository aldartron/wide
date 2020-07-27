package co.wide.auth.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_auth")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    // TODO Добавить возможность нескольких ролей. возможно отдельную таблицу-справочник
    private String role;

}
