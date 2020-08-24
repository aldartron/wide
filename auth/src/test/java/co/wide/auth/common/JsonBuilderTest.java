package co.wide.auth.common;

import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonBuilderTest {

    @Builder
    @Getter
    private static class JsonTest {
        private final String name;
        private final int age;
        private final List<String> list;
        private final boolean enable;
    }

    @Test
    public void convert_to_json_success() {
        JsonTest obj = JsonTest.builder()
                .name("Вася")
                .age(3)
                .enable(true)
                .list(List.of("Трудяга", "Парень"))
                .build();

        var json = JsonBuilder.convertToJson(obj);

        assertEquals(json,
                "{\"name\":\"Вася\"," +
                        "\"age\":3," +
                        "\"list\":[\"Трудяга\",\"Парень\"]," +
                        "\"enable\":true}");
    }

    @Test
    public void convert_to_json_empty() {
        var json = JsonBuilder.convertToJson(null);

        System.out.println(json);

        assertTrue(StringUtils.isBlank(json));
    }

}