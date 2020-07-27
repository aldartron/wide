package co.wide.core;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final BuildProperties buildProperties;

    @GetMapping(value = {"", "/"})
    public String welcomePage() {
        return String.format("<b>Welcome to Wide Core %s</b>" +
                        "<p><a href= ./swagger-ui.html>Swagger</a></p>", buildProperties.getVersion());
    }

}