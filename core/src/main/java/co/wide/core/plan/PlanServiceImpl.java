package co.wide.core.plan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;

    @Override
    public Plan createPlan(String name) {
        return null;
    }

    @Override
    public List<Plan> getPlans() {
        return null;
    }

    @Override
    public Plan getPlan(Long id) {
        return null;
    }

}
