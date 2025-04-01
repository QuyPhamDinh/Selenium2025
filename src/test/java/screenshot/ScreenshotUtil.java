package screenshot;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    protected static final Logger logger = LogManager.getLogger(ScreenshotUtil.class);

    public static void takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            logger.info("WebDriver is null, cannot take screenshot!");
            return;
        }

        // Generate timestamped filename
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "screenshots/" + testName + "_" + timestamp + ".png";

        try {
            // Take screenshot and store it as a file
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(fileName);

            // Ensure directory exists
            FileUtils.copyFile(srcFile, destFile);
            logger.info("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            logger.info("Failed to take screenshot: " + e.getMessage());
        }
    }
}

