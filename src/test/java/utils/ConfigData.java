package utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigData {
    private String browser;
    private String gridUrl;
    private Map<String, String> environments;  // Stores environment URLs

    public String getEnvUrl(String env) {
        return environments.getOrDefault(env, environments.get("dev")); // Default to "dev"
    }
}



