package co.wide.core.plan;

import java.util.List;

public interface PlanService {

    Plan createPlan(String name);

    List<Plan> getPlans();

    Plan getPlan(Long id);

}
