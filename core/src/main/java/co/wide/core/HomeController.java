package co.wide.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/swagger-ui.html";
    }
}