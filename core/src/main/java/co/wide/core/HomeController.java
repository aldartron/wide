package co.wide.core;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping(value = {"", "/"})
    public String welcomePage() {
        return String.format("<b>Welcome to Wide Core %s</b>" +
                "<p><a href= ./swagger-ui.html>Swagger</a></p>", "0.0.1");
    }

}