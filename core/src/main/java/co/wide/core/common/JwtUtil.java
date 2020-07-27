package co.wide.core.common;

import co.wide.core.config.AppConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private static final String ROLES = "roles";
    private final AppConfig appConfig;

    public String extractId(String token) {
        return extractClaim(token, Claims::getId);
    }

    public String extractSubject(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    @SuppressWarnings("unchecked")
    public List<String> extractRoles(String token) {
        return (List<String>) extractClaim(token, claims -> claims.get(ROLES));
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getHmacShaKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private SecretKey getHmacShaKey() {
        return Keys.hmacShaKeyFor(appConfig.getJwtKey().getBytes());
    }

}
