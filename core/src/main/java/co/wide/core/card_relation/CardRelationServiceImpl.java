package co.wide.core.card_relation;

import co.wide.core.card.Card;
import co.wide.core.card.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardRelationServiceImpl implements CardRelationService {

    private final CardRelationRepository cardRelationRepository;
    private final CardRelationMapper cardRelationMapper;
    private final CardMapper cardMapper;

    @Override
    public CardRelation createCardRelation(Card first, Card second) {
        var entity = new CardRelationEntity();
        entity.setFirst(cardMapper.toEntity(first));
        entity.setSecond(cardMapper.toEntity(second));

        return cardRelationMapper.fromEntity(cardRelationRepository.save(entity));
    }
}
