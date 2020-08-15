package co.wide.auth.common;

import co.wide.auth.config.AppConfig;
import lombok.RequiredArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.security.Key;
import java.util.Base64;

@Converter
@RequiredArgsConstructor
public class CryptoConverter implements AttributeConverter<String, String> {

    private final AppConfig appConfig;

    @Override
    public String convertToDatabaseColumn(String ccNumber) {
        Key key = new SecretKeySpec(appConfig.getCryptoEncryptKey().getBytes(),
                appConfig.getCryptoEncryptAlgorithm());

        try {
            Cipher cipher = Cipher.getInstance(appConfig.getCryptoEncryptCipher());
            cipher.init(Cipher.ENCRYPT_MODE, key);

            return Base64.getEncoder().encodeToString(cipher.doFinal(ccNumber.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        Key key = new SecretKeySpec(appConfig.getCryptoEncryptKey().getBytes(),
                appConfig.getCryptoEncryptAlgorithm());

        try {
            Cipher cipher = Cipher.getInstance(appConfig.getCryptoEncryptCipher());
            cipher.init(Cipher.DECRYPT_MODE, key);

            return new String(cipher.doFinal(Base64.getDecoder().decode(dbData)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}