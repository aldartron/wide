package co.wide.render;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class RenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RenderApplication.class, args);
    }

}
