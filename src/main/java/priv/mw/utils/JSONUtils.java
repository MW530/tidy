package priv.mw.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> T parseJSON(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }
}
