package co.wide.core.card_relation;

import co.wide.core.card.Card;

public interface CardRelationService {

    CardRelation createCardRelation(Card first, Card second);
}
