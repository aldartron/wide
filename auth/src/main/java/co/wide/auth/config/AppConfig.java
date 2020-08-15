package co.wide.auth.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AppConfig {

    @Value("${jwt.key}")
    private String jwtKey;

    @Value("${jwt.expiration:86400}")
    private String jwtExpiration;

    @Value("${auth.username}")
    private String authUsername;

    @Value("${auth.password}")
    private String authPassword;

    @Value("${crypto.encrypt.key}")
    private String cryptoEncryptKey;

    @Value("${crypto.encrypt.cipher}")
    private String cryptoEncryptCipher;

    @Value("${crypto.encrypt.algorithm}")
    private String cryptoEncryptAlgorithm;

}
