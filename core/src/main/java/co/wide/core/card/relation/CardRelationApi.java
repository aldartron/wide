package co.wide.core.card.relation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/card/")
public interface CardRelationApi {

    @PostMapping
    CardRelation saveCardRelation(CardRelationRequest cardRelationRequest);

    @GetMapping("/{cardId}/couple")
    List<CardRelation> getCoupleRelations(@PathVariable Long cardId);

    @GetMapping("/{cardId}/nested")
    List<CardRelation> getNestedRelations(@PathVariable Long cardId);

}
