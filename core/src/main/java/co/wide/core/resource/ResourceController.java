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
    public Resource save(Resource resource) {
        return resourceService.createResourceForCard(
                resource, cardService.getById(resource.getCardId())
        );
    }

    @Override
    public Resource delete(Long resourceId) {
        return resourceService.deleteById(resourceId);
    }

    @Override
    public Resource update(Resource resource) {
        return resourceService.update(resource);
    }

}
