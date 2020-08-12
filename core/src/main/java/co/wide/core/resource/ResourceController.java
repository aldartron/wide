package co.wide.core.resource;

import co.wide.core.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResourceController implements ResourceApi {
    private final ResourceService resourceService;
    private final CardService cardService;

    @Override
    public Resource addToCard(Long cardId, Resource resource) {
        return resourceService.createResourceForCard(
                resource,
                cardService.getById(cardId)
        );
    }

}
