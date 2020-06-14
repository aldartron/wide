package co.wide.core.card;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController implements CardApi {

    private CardService cardService;

    @Override
    public Card getCard(Long id) {
        return cardService.getById(id);
    }

    @Override
    public Card saveCard(Card card) {
        return cardService.createCard(card);
    }
}
