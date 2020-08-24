package co.wide.core.plan.node;

import co.wide.core.card.relation.CardRelationType;
import lombok.Data;

@Data
public class PlanNodeRelation {

    private PlanNode right;
    private CardRelationType type;

}
