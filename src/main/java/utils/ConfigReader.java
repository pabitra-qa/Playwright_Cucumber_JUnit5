package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static String getPropertyValue(String propertyName) {

        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config.properties");
            prop.load(ip);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(propertyName);
    }

}
