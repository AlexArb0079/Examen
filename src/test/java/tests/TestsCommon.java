package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.PagesCommon;

public class TestsCommon {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected PagesCommon pagesCommon;
	
	@BeforeMethod
	public void setUp() {
		//Set up driver
		
		//Windows
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		//Linux
		//System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		
		//Brave
		//options.setBinary("K:\\Programas\\BraveSoftware\\Brave-Browser\\Application\\Brave.exe");

		//Bug in chrome driver
		//options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		
		//Go to site
		driver.navigate().to("http://automationpractice.com/index.php");
		
		//Set up Wait
		wait = new WebDriverWait(driver, 10);
		
		//Set up Pages
		pagesCommon = new PagesCommon(driver, wait);
	}
	
	@AfterMethod
	public void close (ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("target/surefire-reports/Captura - " + result.getMethod().getDescription() + ".PNG"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(result.getMethod().getDescription());
		
		driver.close();
		driver.quit();
	}
	

}
