package co.wide.auth.common;

import co.wide.auth.config.AppConfig;
import co.wide.auth.user.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.*;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private static final String ROLES = "roles";
    private final AppConfig appConfig;

    public String generateTokenByUser(UserEntity user) {
        return createToken(user.getLogin(), user.getId(),
                Map.of(ROLES, List.of(user.getRole())));
    }

    private String createToken(String login, Long id, Map<String, Object> claims) {
        Date creationDate = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(login)
                .setId(String.valueOf(id))
                .setIssuedAt(creationDate)
                .setExpiration(createExpirationDate(creationDate))
                .signWith(getHmacShaKey())
                .compact();
    }

    private Date createExpirationDate(Date creationDate) {
        long expirationSeconds = Long.parseLong(appConfig.getJwtExpiration());
        return new Date(creationDate.getTime() * expirationSeconds * 1000);
    }

    private SecretKey getHmacShaKey() {
        return Keys.hmacShaKeyFor(appConfig.getJwtKey().getBytes());
    }

}
