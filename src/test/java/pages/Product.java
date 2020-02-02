package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product extends PagesCommon {

	private By itemName;
	private By itemColours;
	
	
	public Product(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
		this.itemName = By.xpath("//*[@id=\"center_column\"]//h1[@itemprop=\"name\"]");
		this.itemColours = By.xpath("//*[@id=\"color_to_pick_list\"]");
		
	}
	
	public String getItemName() {
		return driver.findElement(itemName).getText();
	}
	
	public String getCurrentColour() {
		return driver.findElement(itemColours).findElement(By.xpath("//a[@class=\"color_pick selected\"]")).getAttribute("name"); 
	}

}
