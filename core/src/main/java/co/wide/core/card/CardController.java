package co.wide.core.card;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardController implements CardApi {

    private final CardService cardService;

    @Override
    public Card getCard(Long id) {
        return cardService.getById(id);
    }

    @Override
    public Card saveCard(Card card) {
        return cardService.createCard(card);
    }
}
