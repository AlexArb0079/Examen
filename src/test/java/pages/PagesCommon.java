package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
		//TODO: maybe add button
	}
	
	
	public void signIn() {
		driver.findElement(signIn).click();

	}
	
	public void goToCategory(String text) {
		//TODO: refactor
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(categories)));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(categories).findElement(By.xpath("./ul/li/a[@title='" + text + "']")))).click();;

	}
	
}
