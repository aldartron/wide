package co.wide.render.plan;

import org.springframework.stereotype.Controller;

@Controller
public class PlanViewController implements PlanViewApi {

    @Override
    public String planView(Long planId) {
        return "plan_view";
    }

}
