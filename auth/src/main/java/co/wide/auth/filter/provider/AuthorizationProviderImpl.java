package co.wide.auth.filter.provider;

import co.wide.auth.config.AppConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorizationProviderImpl implements AuthorizationProvider {

    private final AppConfig appConfig;

    public boolean isValidAuthorizationHeader(String header) {
        if (header.startsWith("Basic ")) {
            header = header.substring(7);
        }

        List<String> loginAndPassword = decodeLoginAndPasswordUtf8(header);

        if (loginAndPassword.size() != 2) {
            return false;
        }

        return loginAndPassword.contains(appConfig.getAuthLogin()) &&
                loginAndPassword.contains(appConfig.getAuthPassword());
    }

    private List<String> decodeLoginAndPasswordUtf8(String header) {
        try {
            byte[] decode = Base64.getDecoder().decode(header);
            String auth = new String(decode, StandardCharsets.UTF_8);

            return Arrays.asList(auth.split(":"));
        } catch (IllegalArgumentException e) {
            return Collections.emptyList();
        }
    }

}
