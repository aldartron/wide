package co.wide.auth.filter.provider;

import co.wide.auth.config.AppConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorizationProviderImpl implements AuthorizationProvider {

    private final AppConfig appConfig;

    public boolean isValidAuthorizationHeader(String header) {
        if (header.startsWith("Basic ")) {
            header = header.substring(7);
        }

        List<String> list = decodeUtf8(header);

        if (list.size() != 2) {
            return false;
        }

        return list.contains(appConfig.getAuthLogin()) &&
                list.contains(appConfig.getAuthPassword());
    }

    private List<String> decodeUtf8(String header) {
        byte[] decode = Base64.getDecoder().decode(header);
        String auth = new String(decode, StandardCharsets.UTF_8);

        return Arrays.asList(auth.split(":"));
    }

}
