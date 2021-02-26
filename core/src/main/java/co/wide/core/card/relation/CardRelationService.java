package co.wide.core.card.relation;

import co.wide.core.card.Card;

import java.util.List;

public interface CardRelationService {

    List<CardRelation> getCoupleRelations(Card card);

    List<CardRelation> getNestedRelations(Card card);

    CardRelation createCardRelationOfType(Card leftCardId, Card rightCardId, CardRelationType relationType);
}
