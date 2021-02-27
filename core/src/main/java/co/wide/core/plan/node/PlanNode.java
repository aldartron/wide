package co.wide.core.plan.node;

import lombok.Data;

import java.util.List;

@Data
public class PlanNode {

    private Long cardId;
    private String cardTitle;
    private List<PlanNodeRelation> nodeRelations;

}
