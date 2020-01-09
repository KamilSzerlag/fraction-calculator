package polsl.jium.kszerlag.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class to retrive value from properties file.
 *
 * @version 1.0
 * @author Kamil Szerląg
 */
class PropertiesHelper {
    
    /**
     * Path to file containing properites.
     */
    private final String properitesPath = "src/resources/app.properties";
    
    /**
     * Retriving values from the property file.
     * Path to property should be specified in propertiesPath field.
     * 
     * @param key specified key for expected property value.
     * @return property value by the key. 
     */
    String getProperty(String key) {
        try (InputStream input = new FileInputStream(properitesPath)) {
            Properties properties = new Properties();
            properties.load(input);
            return properties.getProperty(key);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
