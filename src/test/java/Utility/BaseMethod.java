package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BaseMethod {
	private static WebDriver driver;
	
	public BaseMethod(WebDriver driver) {
        this.driver = driver;
        
    }
	
	
	public static void clickElementWithJavaScript(WebElement element, WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}