package Utliliti;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

    public Properties getProperty() throws IOException
    {
        FileInputStream inputStream=null;
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/przegladarka.properties"));
            properties.load(new FileInputStream("resources/przegladarka.properties"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return properties;
    }


}
