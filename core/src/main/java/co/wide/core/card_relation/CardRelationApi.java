package co.wide.core.card_relation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/card/relation")
public interface CardRelationApi {

    @PostMapping
    CardRelation saveCardRelation(Long firstCardId, Long secondCardId);
}
