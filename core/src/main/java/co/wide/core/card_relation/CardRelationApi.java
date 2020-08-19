package co.wide.core.card_relation;

import co.wide.core.card.Card;

public interface CardRelationApi {

    CardRelation saveCardRelation(Card first, Card second);
}
