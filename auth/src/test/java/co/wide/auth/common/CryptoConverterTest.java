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
        var pass = "1234";
        var cipher = cryptoConverter.convertToDatabaseColumn(pass);

        assertEquals(pass, cryptoConverter.convertToEntityAttribute(cipher));
    }

    @Test
    public void convert_to_database_column_fail() {
        var pass = "1234";
        var cipher = cryptoConverter.convertToDatabaseColumn("5566");

        assertNotEquals(pass, cryptoConverter.convertToEntityAttribute(cipher));
    }

    @Test
    void convert_to_entity_attribute_success() {
        var cipher = "3+G3iV8qamedsXA0IGBfjQ==";
        var pass = cryptoConverter.convertToEntityAttribute(cipher);

        assertEquals(cipher, cryptoConverter.convertToDatabaseColumn(pass));
    }

    @Test
    void convert_to_entity_attribute_fail() {
        var cipher = "3+G3iV8qamedsXA0IGBfjW==";
        var pass = cryptoConverter.convertToEntityAttribute("3+G3iV8qamedsXA0IGBfjQ==");

        assertNotEquals(cipher, cryptoConverter.convertToDatabaseColumn(pass));
    }
}