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
    public CardRelation saveCardRelation(CardRelationRequest cardRelationRequest) {
        return cardRelationService.createCardRelationOfType(
                cardService.getById(cardRelationRequest.getLeftCardId()),
                cardService.getById(cardRelationRequest.getRightCardId()),
                cardRelationRequest.getRelationType()
        );
    }

    @Override
    public List<CardRelation> getCoupleRelations(Long cardId) {
        return cardRelationService.getCoupleRelations(cardService.getById(cardId));
    }

    @Override
    public List<CardRelation> getNestedRelations(Long cardId) {
        return cardRelationService.getNestedRelations(cardService.getById(cardId));
    }

}
