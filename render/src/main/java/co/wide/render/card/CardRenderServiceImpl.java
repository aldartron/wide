package co.wide.render.card;

import co.wide.client.api.CardControllerApi;
import co.wide.client.invoker.ApiException;
import co.wide.client.model.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardRenderServiceImpl implements CardRenderService {
    private final CardControllerApi cardControllerApi = new CardControllerApi();

    @Override
    public Card getCardById(Long cardId) throws ApiException {
        return cardControllerApi.getCardUsingGET(cardId);
    }

}
