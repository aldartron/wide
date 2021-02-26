package co.wide.core.card.relation;

import co.wide.core.card.Card;
import lombok.Data;

/**
 * Contains links to bounded cards with type of the relation
 */
@Data
public class CardRelation {

    private Long id;
    private Card left;
    private Card right;
    private String description;
    private CardRelationType relationType;

}
