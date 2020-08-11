package co.wide.render.card;

import co.wide.client.invoker.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequiredArgsConstructor
public class CardViewController implements CardViewApi {
    private final CardRenderService cardRenderService;

    @Override
    public String cardView(Long cardId, Model model) throws ApiException {
        model.addAttribute("card", cardRenderService.getCardById(cardId));
        return "card_view";
    }

    @ExceptionHandler({ApiException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleApiException() {}

}
