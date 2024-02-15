package Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BaseMethod {
	private static WebDriver driver;
	
	public BaseMethod(WebDriver driver) {
        this.driver = driver;
        
    }
	
	// Methods to click with JavascriptExecutor 
	public static void clickElementWithJavaScript(WebElement element, WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
	
	 public String getSearchTextFromExcel() {
	        String searchText;
			try {
				searchText = ExcelUtility.getCellValue(2, 1);
				return searchText;
			} catch (Exception e) {
				
				e.printStackTrace();
				return null;
			}
	        
	    }
	 
	 public static String generateEmail() {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
	        String dateStamp = sdf.format(new Date());
	        String email = "testecomm335+" + dateStamp + "@gmail.com";
	        return email;
	    }
}
