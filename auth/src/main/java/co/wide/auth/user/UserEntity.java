package co.wide.auth.user;

import co.wide.auth.common.CryptoConverter;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_auth")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String username;

    @Convert(converter = CryptoConverter.class)
    private String password;

    // TODO Добавить возможность нескольких ролей. возможно отдельную таблицу-справочник
    private String role;

}
