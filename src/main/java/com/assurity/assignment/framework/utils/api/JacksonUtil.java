package com.assurity.assignment.framework.utils.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonUtil {

    private final ObjectMapper objectMapper;

    public JacksonUtil() {
        objectMapper = new ObjectMapper();
    }

    /**
     * Deserialize json string to object
     *
     * @param jsonString Json string {@link String}
     * @param type Object type to be converted to {@link Class}
     * @return Deserialized {@link T} generic object
     */
    public <T> T convert(String jsonString, Class<?> type) {
        try {
            if (jsonString == null) {
                return null;
            } else {
                return (T) objectMapper.readValue(jsonString, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Serialize json object to string
     *
     * @param value Json object {@link Object}
     * @return Serialized {@link String} object
     */
    public String convertToString(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
