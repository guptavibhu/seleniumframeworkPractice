package Pages;

import Utility.PropertyFileReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Properties;

/**
 * Created by vibhu on 9/22/2016.
 */
public class SeleniumMethods {

    WebDriver driver = null;
    Properties prop, propValue;


    public String OpenUrl(String urlString) {

        prop = PropertyFileReader.locatorFileReader("C:\\Users\\xeadmin\\IdeaProjects\\selenium-ui\\src\\main\\java\\Utility\\locators.properties");
        propValue = PropertyFileReader.locatorFileReader("C:\\Users\\xeadmin\\IdeaProjects\\selenium-ui\\src\\main\\java\\Utility\\locatorsvalue.properties");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vibhu.gupta\\chromedriver_win32\\chromedriver.exe");
        try {
            driver = new ChromeDriver();
            driver.get(propValue.getProperty(urlString));
        } catch (Exception e) {
            e.getMessage();
            return "Fail";
        }

        return "Pass";
    }

    public String clickButton(String locator) {
        WebElement element = null;
        String[] loc = prop.getProperty(locator).split("=@");
        String locatorType = loc[0];
        String locatorValue = loc[1];
        try {


            switch (locatorType) {

                case "id":
                    element = driver.findElement(By.id(locatorValue));
                    break;
                case "name":
                    element = driver.findElement(By.name(locatorValue));
                    break;
                case "xpath":
                    element = driver.findElement(By.xpath(locatorValue));
                    break;
                default:
                    element = driver.findElement(By.cssSelector(locatorValue));

            }
            element.click();
        } catch (Exception e) {
            e.getMessage();
            return "Fail";
        }
        return "Pass";
    }


    public String enterText(String locator, String value) {

        WebElement element = null;
        String[] loc = prop.getProperty(locator).split("=@");
        String locatorType = loc[0];
        String locatorValue = loc[1];
        try {


            switch (locatorType) {

                case "id":
                    element = driver.findElement(By.id(locatorValue));
                    break;
                case "name":
                    element = driver.findElement(By.name(locatorValue));
                    break;
                case "xpath":
                    element = driver.findElement(By.xpath(locatorValue));
                    break;
                default:
                    element = driver.findElement(By.cssSelector(locatorValue));

            }

            element.sendKeys(propValue.getProperty(value));
        } catch (Exception e) {
            e.getMessage();
            return "Fail";
        }

        return "Pass";
    }

    /*
        public void uploadImage() {

         UploadImage.uploadfile();
    }
    */
    public void alertHandle() {
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.accept();
    }
}
