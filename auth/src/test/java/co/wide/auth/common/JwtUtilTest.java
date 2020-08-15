package co.wide.auth.common;

import co.wide.auth.config.AppConfig;
import co.wide.auth.user.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.yml")
class JwtUtilTest {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AppConfig appConfig;

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(appConfig.getJwtKey().getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Test
    public void jwt_generate_token_by_user_success() {
        var userEntity = new UserEntity();
        userEntity.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        userEntity.setUsername("Dog");
        userEntity.setRole("TESTER");

        var token = jwtUtil.generateTokenByUser(userEntity);
        Claims body = getClaims(token);

        var subject = body.getSubject();
        //noinspection unchecked
        List<String> list = body.get("roles", List.class);
        var role = list.stream().findFirst().orElseGet(() -> {
            Assert.fail("Исключения быть не должно");
            return null;
        });

        assertEquals(role, userEntity.getRole());
        assertEquals(subject, userEntity.getId().toString());
    }

    @Test
    public void jwt_generate_token_by_user_only_subject_success() {
        var userEntity = new UserEntity();
        userEntity.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));

        var token = jwtUtil.generateTokenByUser(userEntity);
        Claims body = getClaims(token);

        var id = body.getSubject();

        assertEquals(id, String.valueOf(userEntity.getId()));
    }

    @Test
    public void jwt_generate_token_by_user_empty() {
        var userEntity = new UserEntity();

        var token = jwtUtil.generateTokenByUser(userEntity);
        Claims body = getClaims(token);

        var subject = body.getSubject();
        var id = body.getId();
        //noinspection unchecked
        List<String> list = body.get("roles", List.class);

        assertNull(subject);
        assertNull(id);
        assertTrue(list.isEmpty());
    }

}