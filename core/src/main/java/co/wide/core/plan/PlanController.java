package co.wide.core.plan;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlanController implements PlanApi {
    private final PlanService planService;

    @Override
    public Plan createPlan(String name) {
        return planService.createPlan(name);
    }

    @Override
    public List<Plan> getPlans() {
        return planService.getPlans();
    }

    @Override
    public Plan getPlan(Long id) {
        return planService.getPlan(id);
    }

}
