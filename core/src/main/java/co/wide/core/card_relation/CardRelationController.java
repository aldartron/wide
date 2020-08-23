package co.wide.core.card_relation;

import co.wide.core.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardRelationController implements CardRelationApi {

    private final CardRelationService cardRelationService;
    private final CardService cardService;

    @Override
    public CardRelation saveCardRelation(Long firstCardId, Long secondCardId) {
        return cardRelationService.createCardRelation(cardService.getById(firstCardId),
                cardService.getById(secondCardId));
    }

    @Override
    public List<CardRelation> getCardRelations(Long cardId) {
        return cardRelationService.getCardRelations(cardService.getById(cardId));
    }
}
