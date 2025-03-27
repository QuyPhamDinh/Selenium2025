package testDataManagement;

import java.util.HashMap;
import java.util.Map;

public class TestDataManager {
    private static TestDataManager instance;
    private Map<String, Object> testData;  // Generic storage for different test data types

    private TestDataManager() {
        testData = new HashMap<>();
    }

    public static synchronized TestDataManager getInstance() {
        if (instance == null) {
            instance = new TestDataManager();
        }
        return instance;
    }

    public void setData(String key, Object value) {
        testData.put(key, value);
    }

    public <T> T getData(String key, Class<T> type) {
        return type.cast(testData.get(key));
    }

    public void clearData() {
        testData.clear();
    }
}

