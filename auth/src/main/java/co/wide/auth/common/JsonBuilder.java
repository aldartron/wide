package co.wide.auth.common;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBuilder {

    public static String convertToJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            return "";
        }
    }

}
