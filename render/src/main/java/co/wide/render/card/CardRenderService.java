package co.wide.render.card;

import co.wide.client.invoker.ApiException;
import co.wide.client.model.Card;

public interface CardRenderService {

    Card getCardById(Long cardId) throws ApiException;

}
