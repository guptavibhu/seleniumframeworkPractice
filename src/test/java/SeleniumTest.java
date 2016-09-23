
import Pages.SeleniumMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by vibhu on 9/20/2016.
 */
public class SeleniumTest {


    @Test
    public void test() throws InterruptedException {

SeleniumMethods objSeleniumMethods = new SeleniumMethods();

        objSeleniumMethods.OpenUrl("url");
        objSeleniumMethods.clickButton("firstForm");

        objSeleniumMethods.clickButton("secondForm");

        objSeleniumMethods.enterText("firstName","firstNameValue");

        objSeleniumMethods.enterText("lastName","lastNameValue");

        objSeleniumMethods.clickButton("sex");

        objSeleniumMethods.clickButton("vichle");

        objSeleniumMethods.clickButton("image");

        UploadImage.uploadFile("C:\\vibhu\\IMG_20160703_185400.jpg");
        Thread.sleep(2000);

        objSeleniumMethods.clickButton("alert");

        objSeleniumMethods.alertHandle();
        objSeleniumMethods.clickButton("submit");
//       String thanksmsg = driver.findElement(By.id("demo")).getText();
//        Assert.assertTrue(thanksmsg.contains("vibhu"));




    }


}
