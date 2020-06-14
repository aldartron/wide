package co.wide.core.user;

import co.wide.core.card.Card;
import lombok.Data;

import java.util.List;

/**
 * Сущность пользователя.
 * Здесь только прикладная информация о нём, логин и пароль будут
 * в другой сущности
 */
@Data
public class User {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
//    private List<WideMap> plans; TODO: add after plan feature implemented
    private List<Card> cards;

}
