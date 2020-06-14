package co.wide.core.card;

public interface CardService {

    Card getById(Long id);

    Card createCard(Card card);
}
