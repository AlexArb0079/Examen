package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Category;
import pages.Product;

public class DropdownsTest extends TestsCommon {

	@Test
	public void dress() {
		pagesCommon.goToCategory("T-shirts");
		
		Category category = new Category(driver, wait);
		

		
		
		String itemName = category.getItemByColor(1, "blue");
		
		Product product = new Product(driver, wait);
		
		Assert.assertEquals(product.getItemName(), itemName);
		Assert.assertEquals(product.getCurrentColour(), "Blue");
		
	}
	
}
