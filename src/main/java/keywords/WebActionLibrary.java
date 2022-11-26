package keywords;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.testng.Assert;

public class WebActionLibrary {
	
	public static WebDriver driver;
	
	public static void openBrowser(String browser, String url) {
		try {
			switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						"E:\\Training\\CucumberTraining\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "ie":
				System.setProperty("webdriver.chrome.driver",
						"E:\\Training\\CucumberTraining\\driver\\chromedriver.exe");
				driver = new InternetExplorerDriver();
				break;
			}
			driver.manage().window().maximize();
			driver.get(url);
			System.out.println("Browser opened successfully");
		} catch (Throwable e) {
			System.out.println("Unable to open browser");
		}

	}
	
	
	
	public static void takeScreenshot() {
		try {
			String date = new SimpleDateFormat("MM/dd/yyyy mmss").format(new Date());
			File pic = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(pic,
					new File("E:\\Cucumber Project\\ProjectCucumber\\Screenshot\\HomePage" + date + ".png"));
			System.out.println("Screenshot taken successfully");
		} catch (Throwable e) {
			System.out.println("Unable to take screenshot");
		}
	}
	
	
	public static void clickElement(WebElement element) {
		try {
			element.click();
			System.out.println("Element clicked succesfully");
		}catch(Throwable e) {
			System.out.println("Unable to click the element");
		}
	}
	
	
	
	public static void validateTitle() {
		try {
			String title = driver.getTitle();
			Assert.assertEquals(title, Labels.pageTitle);
			takeScreenshot();
			System.out.println("Page title validated successfully");
		}catch(Throwable e) {
			System.out.println("Unable to validate page title");
		}
	}
	
	public static void closeAllBrowser() {
		try {
			driver.quit();
			System.out.println("All Browser opened successfully");
		} catch (Throwable e) {
			System.out.println("Unable to close browser");
		}
	}
	
	public static void closeBrowser() {
		try {
			driver.close();
			System.out.println("Current Browser opened successfully");
		} catch (Throwable e) {
			System.out.println("Unable to close browser");
		}
	}
	

}
