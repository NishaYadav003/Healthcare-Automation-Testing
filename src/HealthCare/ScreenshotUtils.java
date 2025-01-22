package HealthCare;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Allure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ScreenshotUtils {

    public static void captureScreenshot(WebDriver driver) throws IOException {
       
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

      
        String screenshotPath = "target/screenshots/screenshot_" + System.currentTimeMillis() + ".png";
        FileUtils.copyFile(screenshotFile, new File(screenshotPath));

     
        Allure.addAttachment("Screenshot", new FileInputStream(screenshotFile));
    }
}
