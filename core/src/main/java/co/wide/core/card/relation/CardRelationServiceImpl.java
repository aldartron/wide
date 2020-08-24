package co.wide.core.card.relation;

import co.wide.core.card.Card;
import co.wide.core.card.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardRelationServiceImpl implements CardRelationService {

    private final CardRelationRepository cardRelationRepository;
    private final CardRelationMapper cardRelationMapper;
    private final CardMapper cardMapper;

    @Override
    public CardRelation createCardRelation(Card left, Card right) {
        var entity = new CardRelationEntity();
        entity.setLeft(cardMapper.toEntity(left));
        entity.setRight(cardMapper.toEntity(right));

        return cardRelationMapper.fromEntity(cardRelationRepository.save(entity));
    }

    @Override
    public List<CardRelation> getCardRelations(Card card) {
        if (card == null) return null;

        return cardRelationRepository
                .findByLeftOrRightOrderById(cardMapper.toEntity(card), cardMapper.toEntity(card))
                .stream()
                .map(cardRelationMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
