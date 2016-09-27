
import Pages.SeleniumMethods;
import Utility.ExcelReader;
import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.TCKind;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;



/**
 * Created by vibhu on 9/20/2016.
 */
public class SeleniumTest {

    String filePath = "C:\\Users\\xeadmin\\IdeaProjects\\selenium-ui\\src\\main\\resources";
    SeleniumMethods objSeleniumMethods = new SeleniumMethods();

//        objSeleniumMethods.clickButton("image");
//        UploadImage.uploadFile("C:\\vibhu\\IMG_20160703_185400.jpg");
//        Thread.sleep(2000);
//        objSeleniumMethods.clickButton("alert");
//        objSeleniumMethods.alertHandle();

////      String thanksmsg = driver.findElement(By.id("demo")).getText();
////      Assert.assertTrue(thanksmsg.contains("vibhu"));


    @Test
    public void excelReading() throws IOException {

        try {
            //define a HTML String Builder
            StringBuilder htmlStringBuilder = new StringBuilder();
            //append html header and title
            htmlStringBuilder.append("<html><head><title>Selenium Test </title></head>");
            //append body
            htmlStringBuilder.append("<body>");
            //append table
            htmlStringBuilder.append("<table border=\"1\" bordercolor=\"#000000\">");
            //append row
            htmlStringBuilder.append("<tr><td><b>TestId</b></td><td><b>TestName</b></td><td><b>TestResult</b></td></tr>");
            //append row
    //        htmlStringBuilder.append("<tr><td></td><td>Login</td><td>Passed</td></tr>");

        //Create an object of ReadGuru99ExcelFile class
        ExcelReader objExcelFile = new ExcelReader();
        //Prepare the path of excel file

        //Call read file method of the class to read data
        objExcelFile.readExcel(filePath, "testcases.xlsx", "Sheet1");

        for (int i = 0; i < ExcelReader.rowCount + 1; i++) {
            String s = new String("TC");
            if (ExcelReader.cellStringValue[i][2].equalsIgnoreCase("y")) {
                ExcelReader.readExcel(filePath, "testcasesteps.xlsx", s + i);
            }
            if (ExcelReader.cellStringValue[i][1].equalsIgnoreCase("Open Browser")) {
                objSeleniumMethods.OpenUrl(ExcelReader.cellStringValue[i][3]);
                //append row
                htmlStringBuilder.append("<tr><td>");
                htmlStringBuilder.append(i);
                htmlStringBuilder.append("</td><td>");
                htmlStringBuilder.append(ExcelReader.cellStringValue[i][0]);
                htmlStringBuilder.append("</td><td>");
                htmlStringBuilder.append(objSeleniumMethods.OpenUrl(ExcelReader.cellStringValue[i][3]));
                htmlStringBuilder.append("</td></tr>");
            } else if (ExcelReader.cellStringValue[i][1].equalsIgnoreCase("Click Button")) {
                objSeleniumMethods.clickButton(ExcelReader.cellStringValue[i][2]);
                htmlStringBuilder.append("<tr><td>");
                htmlStringBuilder.append(i);
                htmlStringBuilder.append("</td><td>");
                htmlStringBuilder.append(ExcelReader.cellStringValue[i][0]);
                htmlStringBuilder.append("</td><td>");
                htmlStringBuilder.append(objSeleniumMethods.clickButton(ExcelReader.cellStringValue[i][2]));
                htmlStringBuilder.append("</td></tr>");
//                htmlStringBuilder.append("</td><td>Passed</td></tr>");
            } else if (ExcelReader.cellStringValue[i][1].equalsIgnoreCase("enter text")) {
                objSeleniumMethods.enterText(ExcelReader.cellStringValue[i][2], ExcelReader.cellStringValue[i][3]);
                htmlStringBuilder.append("<tr><td>");
                htmlStringBuilder.append(i);
                htmlStringBuilder.append("</td><td>");
                htmlStringBuilder.append(ExcelReader.cellStringValue[i][0]);
                htmlStringBuilder.append("</td><td>");
                htmlStringBuilder.append(objSeleniumMethods.enterText(ExcelReader.cellStringValue[i][2], ExcelReader.cellStringValue[i][3]));
                htmlStringBuilder.append("</td></tr>");
 //               htmlStringBuilder.append("</td><td>Passed</td></tr>");

            }
        }
//            //append row
//            htmlStringBuilder.append("<tr><td>002</td><td>Logout</td><td>Passed</td></tr>");
//            //close html file
            htmlStringBuilder.append("</table></body></html>");
            //write html string content to a file
            WriteToFile(htmlStringBuilder.toString(), "testfile.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void html() {

    }

    public static void WriteToFile(String fileContent, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath + File.separator + fileName;
        File file = new File(tempFile);
        // if file does exists, then delete and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator + "backup_" + fileName);
                file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();

    }

}
