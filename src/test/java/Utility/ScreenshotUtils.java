package Utility;

import java.io.File;
import java.text.SimpleDateFormat;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

	  public static void captureScreenshot(WebDriver driver, String screenshotName) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);

	        try {
	            String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
	            Path screenshotPath = Paths.get("screenshots", screenshotName + "_" + timeStamp + ".png");
	            FileHandler.copy(source, screenshotPath.toFile());
	            System.out.println("Screenshot captured: " + screenshotPath.toAbsolutePath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
