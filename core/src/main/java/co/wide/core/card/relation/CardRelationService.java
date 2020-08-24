package co.wide.core.card.relation;

import co.wide.core.card.Card;

import java.util.List;

public interface CardRelationService {

    CardRelation createCardRelation(Card left, Card right);

    List<CardRelation> getCardRelations(Card card);
}
