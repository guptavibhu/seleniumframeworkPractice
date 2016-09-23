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
    Properties prop;

    public void OpenUrl(String urlString){

        prop=PropertyFileReader.locatorFileReader();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vibhu.gupta\\chromedriver_win32\\chromedriver.exe");
        driver =new ChromeDriver();
        driver.get(prop.getProperty(urlString));

    }

    public  void clickButton(String locator)
    {
        WebElement element=null;
        String[] loc = prop.getProperty(locator).split("=@");
        String locatorType = loc[0];
        String locatorValue = loc[1];

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

    }

//    public  static void clickButtonXpath(String locator)
//    {
//        WebElement element = driver.findElement(By.xpath(prop.getProperty(locator)));
//        element.click();
//    }

    public void enterText(String locator, String value){

        WebElement element=null;
        String[] loc = prop.getProperty(locator).split("=@");
        String locatorType = loc[0];
        String locatorValue = loc[1];

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

        element.sendKeys(prop.getProperty(value));
    }

    public void alertHandle(){
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.accept();
    }
}
