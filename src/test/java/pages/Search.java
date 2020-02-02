package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search extends PagesCommon {

	private By searchResult;
	private By foundItems;
	
	public Search(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
		
		searchResult = By.xpath("//*[@id=\"center_column\"]/h1/span[@class=\"heading-counter\"]");
		foundItems = By.xpath("//*[@id=\"center_column\"]/ul[@class=\"product_list grid row\"]");

	}
	
	public String searchResult() {
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult)).getAttribute("innerText");
		
	}
	
	public boolean itemFound(String text) {
		return !driver.findElement(foundItems).findElements(By.xpath("//a[@title=\"" + text + "\"]")).isEmpty();
	}

}
