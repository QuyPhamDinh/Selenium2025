package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigReader {
    private static ConfigReader instance;
    private ConfigData config;

    private ConfigReader() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            config = objectMapper.readValue(new File("src/test/resources/config.json"), ConfigData.class);
        } catch (IOException e) {
            throw new RuntimeException("Error reading config file", e);
        }
    }

    public static ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    }

    public ConfigData getConfig() {
        return config;
    }
}

