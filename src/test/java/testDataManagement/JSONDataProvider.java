package testDataManagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;

public class JSONDataProvider implements TestDataProvider {
    private final String filePath;

    public JSONDataProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Map<String, String>> getData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(filePath), List.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

