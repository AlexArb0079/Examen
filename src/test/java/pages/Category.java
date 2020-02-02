package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Category extends PagesCommon {

	private By currentCategorie;
	private By subcategories;
	private By itemList;
	private By sortBy;
	
	public Category(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
		currentCategorie = By.xpath("//*[@id=\"center_column\"]/h1/span[@class=\"cat-name\"]");
		subcategories = By.xpath("//*[@id=\"subcategories\"]/ul");
		itemList = By.xpath("//*[@id=\"center_column\"]/ul");
		sortBy = By.id("selectProductSort");
	
	
	}

	public void goToSubCategorie(String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(subcategories));
		driver.findElement(subcategories).findElement(By.xpath("//a[@class=\"subcategory-name\"][text()[contains(.,'" + text + "')]]")).click();
	}
	
	public String getCurrentCategorie() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(currentCategorie));
		return driver.findElement(currentCategorie).getText();
	}
	
	public String getItemByColor(int position, String colour) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(itemList));
		
		WebElement item = driver.findElement(itemList).findElement(By.xpath("./li[position() = " + position + "]"));
		
		String itemName = item.findElement(By.xpath(".//a[@class=\"product-name\"]")).getAttribute("title");
			
		wait.until(ExpectedConditions.elementToBeClickable(item.findElement(By.xpath(".//a[@class=\"color_pick\"][contains(@href,'/color-" + colour + "')]")))).click();
		
		return itemName;
		
	}
	
	public void sortResults(String condition, String order) {
		
		new Select(driver.findElement(sortBy)).selectByValue(condition + ":" + order);
		
	}
	
}

