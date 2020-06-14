package co.wide.core.plan;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plan")
public interface PlanApi {

    @PostMapping
    Plan createPlan(@PathVariable String name);

    @GetMapping
    List<Plan> getPlans();

    @GetMapping("/{id}")
    Plan getPlan(@PathVariable Long id);
}
