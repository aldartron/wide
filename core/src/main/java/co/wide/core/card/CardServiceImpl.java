package co.wide.core.card;

public class CardServiceImpl implements CardService{

    private CardRepository cardRepository;

    @Override
    public Card getById(Long id) {
        return cardRepository.getOne(id);
    }

    @Override
    public Card createCard(Card card) {
        return cardRepository.save(card);
    }
}
