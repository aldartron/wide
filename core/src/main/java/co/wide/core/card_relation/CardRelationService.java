package co.wide.core.card_relation;

import co.wide.core.card.CardEntity;

public interface CardRelationService {

    CardRelation createCardRelation(CardEntity first, CardEntity second);
}
