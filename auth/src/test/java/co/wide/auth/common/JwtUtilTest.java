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
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        userEntity.setLogin("Dog");
        userEntity.setRole("TESTER");

        String token = jwtUtil.generateTokenByUser(userEntity);
        Claims body = getClaims(token);

        String subject = body.getSubject();
        //noinspection unchecked
        List<String> list = body.get("roles", List.class);
        String role = list.stream().findFirst().orElseGet(() -> {
            Assert.fail("Исключения быть не должно");
            return null;
        });

        assertEquals(role, userEntity.getRole());
        assertEquals(subject, userEntity.getId().toString());
    }

    @Test
    public void jwt_generate_token_by_user_only_subject_success() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));

        String token = jwtUtil.generateTokenByUser(userEntity);
        Claims body = getClaims(token);

        String id = body.getSubject();

        assertEquals(id, String.valueOf(userEntity.getId()));
    }

    @Test
    public void jwt_generate_token_by_user_empty() {
        UserEntity userEntity = new UserEntity();

        String token = jwtUtil.generateTokenByUser(userEntity);
        Claims body = getClaims(token);

        String subject = body.getSubject();
        String id = body.getId();
        //noinspection unchecked
        List<String> list = body.get("roles", List.class);

        assertNull(subject);
        assertNull(id);
        assertTrue(list.isEmpty());
    }

}