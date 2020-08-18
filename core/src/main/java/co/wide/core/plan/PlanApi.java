package co.wide.core.plan;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/plan")
public interface PlanApi {

    @PostMapping
    Plan createPlan(@RequestParam String name);

//    Можем создавать план без названия?
//    @PostMapping
//    Plan createPlan(@RequestParam String token);

    @GetMapping
    List<Plan> getPlans();

    @GetMapping("/{id}")
    Plan getPlan(@PathVariable Long id);
    
}
