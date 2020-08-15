package co.wide.core.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AppConfig {

    @Value("${jwt.key}")
    private String jwtKey;

    @Value("${auth.username}")
    private String authUsername;

    @Value("${auth.password}")
    private String authPassword;

}
