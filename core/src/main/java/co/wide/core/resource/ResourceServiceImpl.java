package co.wide.core.resource;

import co.wide.core.card.Card;
import co.wide.core.card.CardMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class ResourceServiceImpl implements ResourceService {
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;
    private final CardMapper cardMapper;

    @Override
    public Optional<Resource> getById(Long id) {
        return resourceRepository
                .findById(id)
                .map(resourceMapper::fromEntity);
    }

    @Override
    public List<Resource> getByCard(Card card) {
        return resourceRepository
                .findByCardId(card.getId()).stream()
                .map(resourceMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Resource createResourceForCard(@NonNull Resource resource, Card card) {
        ResourceEntity entity = resourceMapper.toEntity(resource);
        entity.setCard(cardMapper.toEntity(card));
        return resourceMapper.fromEntity(
                resourceRepository.save(entity)
        );
    }

    @Override
    public Resource deleteById(Long resourceId) {
        Resource resourceToDelete = resourceMapper.fromEntity(
                resourceRepository.getOne(resourceId)
        );
        resourceRepository.deleteById(resourceId);
        return resourceToDelete;
    }

    @Override
    public Resource update(Resource resource) {
        ResourceEntity resourceUpdatedEntity = resourceMapper.toEntity(resource);
        return resourceMapper.fromEntity(resourceRepository.save(resourceUpdatedEntity));
    }
}
