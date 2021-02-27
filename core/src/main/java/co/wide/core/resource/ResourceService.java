package co.wide.core.resource;

import co.wide.core.card.Card;

import java.util.List;
import java.util.Optional;

public interface ResourceService {

    Optional<Resource> getById(Long id);

    List<Resource> getByCard(Card card);

    Resource createResourceForCard(Resource resource, Card card);

    Resource deleteById(Long resourceId);

    Resource update(Resource resource);

}
