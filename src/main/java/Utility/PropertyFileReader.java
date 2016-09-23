package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by vibhu on 9/22/2016.
 */
public class PropertyFileReader {

    public static Properties locatorFileReader()

    {
        File file = new File("C:\\Users\\xeadmin\\IdeaProjects\\selenium-ui\\src\\main\\java\\Utility\\locators.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
      //  System.out.println("URL ::" + prop.getProperty("firstName"));
        return prop;
    }
    }
