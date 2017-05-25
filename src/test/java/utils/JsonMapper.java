package utils;

import com.google.gson.Gson;
import entities.Credentials;

import java.io.*;


public class JsonMapper {
    private static Gson gson;
    private static Reader reader;

    private JsonMapper() {
        gson = new Gson();
        InputStream credentialsStream = getClass().getClassLoader().getResourceAsStream("Credentials.json");
        reader = new BufferedReader(new InputStreamReader(credentialsStream));
    }

    public static <T> T getCredentials(String mappingClass) {
        new JsonMapper();
        switch (mappingClass) {
            case "Credentials":
                return gson.fromJson(reader, (Class<T>) Credentials.class);
            default:
                return gson.fromJson(reader,(Class<T>) Credentials.class);
        }
    }
}