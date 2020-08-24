package co.wide.core.card.relation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/card/relation")
public interface CardRelationApi {

    @PostMapping
    CardRelation saveCardRelation(Long leftCardId, Long rightCardId);

    @GetMapping("/{cardId}")
    List<CardRelation> getCardRelations(@PathVariable Long cardId);
}
