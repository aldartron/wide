package co.wide.core.card.relation;

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
    public CardRelation saveCardRelation(Long leftCardId, Long rightCardId) {
        return cardRelationService.createCardRelation(cardService.getById(leftCardId),
                cardService.getById(rightCardId));
    }

    @Override
    public List<CardRelation> getCardRelations(Long cardId) {
        return cardRelationService.getCardRelations(cardService.getById(cardId));
    }
}
