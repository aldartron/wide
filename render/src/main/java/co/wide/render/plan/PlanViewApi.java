package co.wide.render.plan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface PlanViewApi {

    @GetMapping("/plan/{planId}")
    String planView(@PathVariable Long planId);


}
