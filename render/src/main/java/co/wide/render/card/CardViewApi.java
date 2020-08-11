package co.wide.render.card;

import co.wide.client.invoker.ApiException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1")
public interface CardViewApi {

    @GetMapping("/card/{cardId}")
    String cardView(@PathVariable Long cardId, Model model) throws ApiException;

}
