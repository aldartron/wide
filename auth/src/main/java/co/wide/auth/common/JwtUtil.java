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
        String subject = null;

        if (user.getId() != null) {
            subject = user.getId().toString();
        }

        return createToken(subject,
                Map.of(ROLES, user.getRole() == null ? Collections.emptyList() : List.of(user.getRole())));
    }

    private String createToken(String subject, Map<String, Object> claims) {
        var creationDate = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(creationDate)
                .setExpiration(createExpirationDate(creationDate))
                .signWith(getHmacShaKey())
                .compact();
    }

    private Date createExpirationDate(Date creationDate) {
        return new Date(creationDate.getTime() +
                Long.parseLong(appConfig.getJwtExpiration()) * 1000);
    }

    private SecretKey getHmacShaKey() {
        return Keys.hmacShaKeyFor(appConfig.getJwtKey().getBytes());
    }

}
