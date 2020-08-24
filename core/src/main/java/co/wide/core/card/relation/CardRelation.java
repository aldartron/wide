package co.wide.core.card.relation;

import co.wide.core.card.Card;
import lombok.Data;

/**
 * Класс просто хранит в себе ссылки
 * на две карты и описание их связи
 */
@Data
public class CardRelation {

    private Long id;
    private Card left;
    private Card right;
    private String description;
    private CardRelationType relationType;
}
