package co.wide.core.card.relation;

import co.wide.core.card.Card;
import co.wide.core.card.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardRelationServiceImpl implements CardRelationService {

    private final CardRelationRepository cardRelationRepository;
    private final CardRelationMapper cardRelationMapper;
    private final CardMapper cardMapper;

    @Override
    public CardRelation createCardRelationOfType(Card left, Card right, CardRelationType relationType) {
        var relationEntity = new CardRelationEntity();
        relationEntity.setLeft(cardMapper.toEntity(left));
        relationEntity.setRight(cardMapper.toEntity(right));
        relationEntity.setType(relationType);

        return cardRelationMapper.fromEntity(
                cardRelationRepository.save(relationEntity)
        );
    }

    @Override
    public List<CardRelation> getCoupleRelations(Card card) {
        if (card == null) {
            return Collections.emptyList();
        }

        return cardRelationRepository
                .findByLeftOrRightOfType(cardMapper.toEntity(card), CardRelationType.COUPLE)
                .stream()
                .map(cardRelationMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CardRelation> getNestedRelations(Card card) {
        if (card == null) {
            return Collections.emptyList();
        }

        return cardRelationRepository
                .findByLeftOfType(cardMapper.toEntity(card), CardRelationType.NESTED)
                .stream()
                .map(cardRelationMapper::fromEntity)
                .collect(Collectors.toList());
    }

}
