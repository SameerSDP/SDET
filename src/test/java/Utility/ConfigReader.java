package Utility;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final String PROPERTIES_FILE = "config.properties";
    private static Properties properties;

    static {
        loadProperties();
    }

    private static void loadProperties() {
        properties = new Properties();
        InputStream input = null;
        try {
            input = ConfigReader.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

   
}
