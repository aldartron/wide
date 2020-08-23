package co.wide.core.card_relation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/card/relation")
public interface CardRelationApi {

    @PostMapping
    CardRelation saveCardRelation(Long firstCardId, Long secondCardId);

    List<CardRelation> getCardRelations(Long cardId);
}
