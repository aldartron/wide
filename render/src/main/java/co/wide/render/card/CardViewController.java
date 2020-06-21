package co.wide.render.card;

import org.springframework.stereotype.Controller;

@Controller
public class CardViewController implements CardViewApi {

    @Override
    public String cardView(Long cardId) {
        // TODO: call core api client
        return "card_view";
    }

}
