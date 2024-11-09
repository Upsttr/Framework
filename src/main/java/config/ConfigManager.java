package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static Properties props = new Properties();

    static {
        try (InputStream input = new FileInputStream("src/main/java/config/config.properties")) {
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return props.getProperty("base.url");
    }

    public static String getDbConnectionString() {
        return props.getProperty("db.connection.string");
    }

    public static String getDbUsername() {
        return props.getProperty("db.username");
    }

    public static String getDbPassword() {
        return props.getProperty("db.password");
    }
}

