package co.wide.render.card;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CardViewApi {

    @GetMapping("/card/{cardId}")
    String cardView(@PathVariable Long cardId);

}
