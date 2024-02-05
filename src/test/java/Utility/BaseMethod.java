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
	
	 public String getSearchTextFromExcel() {
	        String searchText;
			try {
				searchText = ExcelUtility.getCellValue(2, 1);
				return searchText;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	        
	    }
}
