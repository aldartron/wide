package co.wide.core.card_relation;

import co.wide.core.card.CardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardRelationServiceImpl implements CardRelationService {

    private final CardRelationRepository cardRelationRepository;
    private final CardRelationMapper cardRelationMapper;

    @Override
    public CardRelation createCardRelation(CardEntity first, CardEntity second) {
        var entity = new CardRelationEntity();
        entity.setFirst(first);
        entity.setSecond(second);

        return cardRelationMapper.fromEntity(cardRelationRepository.save(entity));
    }
}
