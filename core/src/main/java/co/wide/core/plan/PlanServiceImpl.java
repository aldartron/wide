package co.wide.core.plan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;
    private final PlanMapper planMapper;

    @Override
    public Plan createPlan(String name) {
        var entity = new PlanEntity();
        entity.setName(name);

        return planMapper.fromEntity(
                planRepository.save(entity));
    }

    @Override
    public List<Plan> getPlans() {
        return planMapper.fromEntities(
                planRepository.findAll());
    }

    @Override
    public PlanSimple getSimplePlan(Long id) {
        // TODO: Go, go, Sodnom!
        return null;
    }
}
