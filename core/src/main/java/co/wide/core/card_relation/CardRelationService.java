package co.wide.core.card_relation;

import co.wide.core.card.Card;

import java.util.List;

public interface CardRelationService {

    CardRelation createCardRelation(Card first, Card second);

    List<CardRelation> getCardRelations(Card card);
}
