package co.wide.core.card.relation;

import lombok.Data;

@Data
public class CardRelationRequest {

    private Long leftCardId;
    private Long rightCardId;
    private String description;
    private CardRelationType relationType;

}
