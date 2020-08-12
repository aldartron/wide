package co.wide.auth.common;

import co.wide.auth.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CryptoConverterTest {

    @Autowired
    private CryptoConverter cryptoConverter;

    @TestConfiguration
    static class ContextConfiguration {
        @Autowired
        private AppConfig appConfig;

        @Bean
        public CryptoConverter cryptoConverter() {
            return new CryptoConverter(appConfig);
        }
    }

    @Test
    public void convert_to_database_column_success() {
        String pass = "1234";
        String cipher = cryptoConverter.convertToDatabaseColumn(pass);

        assertEquals(pass, cryptoConverter.convertToEntityAttribute(cipher));
    }

    @Test
    public void convert_to_database_column_fail() {
        String pass = "1234";
        String cipher = cryptoConverter.convertToDatabaseColumn("5566");

        assertNotEquals(pass, cryptoConverter.convertToEntityAttribute(cipher));
    }

    @Test
    void convert_to_entity_attribute_success() {
        String cipher = "3+G3iV8qamedsXA0IGBfjQ==";
        String pass = cryptoConverter.convertToEntityAttribute(cipher);

        assertEquals(cipher, cryptoConverter.convertToDatabaseColumn(pass));
    }

    @Test
    void convert_to_entity_attribute_fail() {
        String cipher = "3+G3iV8qamedsXA0IGBfjW==";
        String pass = cryptoConverter.convertToEntityAttribute("3+G3iV8qamedsXA0IGBfjQ==");

        assertNotEquals(cipher, cryptoConverter.convertToDatabaseColumn(pass));
    }
}