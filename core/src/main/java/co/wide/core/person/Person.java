package co.wide.core.person;

import co.wide.core.card.Card;
import co.wide.core.plan.Plan;
import lombok.Data;

import java.util.List;

/**
 * Сущность пользователя.
 * Здесь только прикладная информация о нём, логин и пароль будут
 * в другой сущности
 */
@Data
public class Person {

    private Long id;
    private String guid;
    private String username;
    private String firstName;
    private String lastName;
    private List<Plan> plans;
    private List<Card> cards;

}
