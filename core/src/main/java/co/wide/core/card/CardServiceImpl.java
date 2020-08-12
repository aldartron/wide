package co.wide.core.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Override
    public Card getById(Long id) {
        return cardMapper.fromEntity(cardRepository.getOne(id));
    }

    @Override
    public Card createCard(Card card) {
        var saved = cardRepository.save(cardMapper.toEntity(card));

        return cardMapper.fromEntity(saved);
    }
}
