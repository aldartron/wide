package co.wide.auth.authenticate;

import co.wide.auth.common.JsonBuilder;
import co.wide.auth.config.AppConfig;
import co.wide.auth.user.UserEntity;
import co.wide.auth.user.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import javax.naming.AuthenticationException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.yml")
class AuthenticateApiTest {

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private String getAuthorizationHeader() {
        return HttpHeaders.encodeBasicAuth(
                appConfig.getAuthLogin(), appConfig.getAuthPassword(), StandardCharsets.UTF_8);
    }

    @Test
    public void login_success() throws Exception {
        var request = new AuthenticateUserRequest();
        request.setLogin("Dog");
        request.setPassword("123");

        var userEntity = new UserEntity();
        userEntity.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        userEntity.setLogin("Dog");
        userEntity.setPassword("123");
        userEntity.setRole("TESTER");

        Mockito.when(userService.getUser(request.getLogin()))
                .thenReturn(Optional.of(userEntity));

        mockMvc.perform(post("/api/auth/login")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, getAuthorizationHeader())
                .content(JsonBuilder.convertToJson(request)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("token").isNotEmpty());
    }

    @Test
    public void login_not_valid() throws Exception {
        var request = new AuthenticateUserRequest();
        request.setLogin("Dog");
        request.setPassword("123");

        Mockito.when(userService.getUser(request.getLogin()))
                .thenThrow(new AuthenticationException());

        mockMvc.perform(post("/api/auth/login")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, getAuthorizationHeader())
                .content(JsonBuilder.convertToJson(request)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("message")
                        .value("Что же ты делаешь урод!!! нельзя тебе!"));
    }

    @Test
    public void login_password_not_valid() throws Exception {
        var request = new AuthenticateUserRequest();
        request.setLogin("Dog");
        request.setPassword("123");

        var userEntity = new UserEntity();
        userEntity.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        userEntity.setLogin("Dog");
        userEntity.setPassword("not valid");
        userEntity.setRole("TESTER");

        Mockito.when(userService.getUser(request.getLogin()))
                .thenReturn(Optional.of(userEntity));

        Mockito.doThrow(new AuthenticationException())
                .when(userService).checkUser(
                ArgumentMatchers.any(),
                ArgumentMatchers.any(UserEntity.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.any(AuthenticateUserRequest.class),
                ArgumentMatchers.any());

        mockMvc.perform(post("/api/auth/login")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, getAuthorizationHeader())
                .content(JsonBuilder.convertToJson(request)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("message")
                        .value("Что же ты делаешь урод!!! нельзя тебе!"));
    }

    @Test
    public void login_header_empty() throws Exception {
        var request = new AuthenticateUserRequest();
        request.setLogin("Dog");
        request.setPassword("123");

        mockMvc.perform(post("/api/auth/login")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .content(JsonBuilder.convertToJson(request)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void login_header_not_valid() throws Exception {
        var request = new AuthenticateUserRequest();
        request.setLogin("Dog");
        request.setPassword("123");

        mockMvc.perform(post("/api/auth/login")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "1")
                .content(JsonBuilder.convertToJson(request)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void login_header_not_fields() throws Exception {
        var request = new AuthenticateUserRequest();

        mockMvc.perform(post("/api/auth/login")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, getAuthorizationHeader())
                .content(JsonBuilder.convertToJson(request)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("message")
                        .value("Оооойй дурак!!! обязательные поля не задал!"));
    }

    @Test
    public void registration_success() throws Exception {
        var request = new AuthenticateUserRegistrationRequest();
        request.setLogin("Dog");
        request.setPassword("123");
        request.setRole("TESTER");

        var userEntity = new UserEntity();
        userEntity.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        userEntity.setLogin("Dog");
        userEntity.setPassword("123");
        userEntity.setRole("TESTER");

        Mockito.when(userService.getUser(request.getLogin()))
                .thenReturn(Optional.empty());

        Mockito.when(userService.createUser(request))
                .thenReturn(userEntity);

        mockMvc.perform(post("/api/auth/registration")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, getAuthorizationHeader())
                .content(JsonBuilder.convertToJson(request)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("token").isNotEmpty());
    }

    @Test
    public void registration_busy() throws Exception {
        var request = new AuthenticateUserRegistrationRequest();
        request.setLogin("Dog");
        request.setPassword("123");
        request.setRole("TESTER");

        var userEntity = new UserEntity();
        userEntity.setId(UUID.nameUUIDFromBytes("Dog".getBytes()));
        userEntity.setLogin("Dog");
        userEntity.setPassword("123");
        userEntity.setRole("TESTER");

        Mockito.when(userService.getUser(request.getLogin()))
                .thenReturn(Optional.of(userEntity));

        mockMvc.perform(post("/api/auth/registration")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, getAuthorizationHeader())
                .content(JsonBuilder.convertToJson(request)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("message")
                        .value("Ужк есть такой красавец!"));
    }

}