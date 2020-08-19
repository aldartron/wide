package co.wide.core.card_relation;

import co.wide.core.card.Card;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CardRelationController implements CardRelationApi {

    private final CardRelationService cardRelationService;

    @Override
    public CardRelation saveCardRelation(Card first, Card second) {
        return cardRelationService.createCardRelation(first, second);
    }
}
