package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagesCommon {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	protected By searchInputText;
	protected By searchButton;
	protected By signIn;
	protected By categories;
	
	public PagesCommon(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		
		searchInputText = By.id("search_query_top");
		searchButton = By.name("submit_search");
		signIn = By.xpath("//a[@class=\"login\"]"); 
		categories = By.xpath("//*[@id=\"block_top_menu\"]");
	}
	
	
	public void search(String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputText)).sendKeys(text, Keys.ENTER);
	}
	
	
	public void signIn() {
		driver.findElement(signIn).click();
		
	}
	
	public void goToCategory(String text) {
		
		//dobug
		//driver.findElement(By.xpath("//a[@title=\"T-shirts\"]")).getAttribute("href");
		//System.out.println(driver.findElement(By.xpath("//a[@title=\"T-shirts\"]")).getAttribute("href"));
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(categories)));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(categories).findElement(By.xpath("//a[@title=\"" + text + "\"]")));
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title=\"Dresses\"]")));
		
		
		/*
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(categories).findElement(By.xpath("//a[@title=\"T-shirts\"]"))));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(categories).findElement(By.xpath("//a[@title=\"" + text + "\"]"))));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", 
				driver.findElement(categories).findElement(By.xpath("//a[@title=\"" + text + "\"]")));

				
				
		
		
		
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(categories).findElement(By.xpath("//li[a[@title=\"" + text + "\"]]"))));
		System.out.println(driver.findElement(categories).findElement(By.xpath("//a[@title=\"" + text + "\"]")).getAttribute("href"));
		driver.findElement(categories).findElement(By.xpath("//a[@title=\"" + text + "\"]")).click();
		*/
		
	}
	
}
