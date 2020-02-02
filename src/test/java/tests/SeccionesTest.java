package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Category;
import pages.Product;

public class SeccionesTest extends TestsCommon {
	
	@Test
	public void dress() {
		pagesCommon.goToCategory("Dresses");
		
		Category category = new Category(driver, wait);
		
		category.goToSubCategorie("Summer Dresses");
		
		Assert.assertEquals(category.getCurrentCategorie(), "SUMMER DRESSES ");
		
		String itemName = category.getItemByColor(1, "blue");
		
		Product product = new Product(driver, wait);
		
		Assert.assertEquals(product.getItemName(), itemName);
		Assert.assertEquals(product.getCurrentColour(), "Blue");
		
	}
	
	@Test
	public void women() {
		pagesCommon.goToCategory("Women");
		
		Category category = new Category(driver, wait);
		
		category.goToSubCategorie("Tops");
		
		Assert.assertEquals(category.getCurrentCategorie(), "TOPS ");
		
		String itemName = category.getItemByColor(2, "white");
		
		Product product = new Product(driver, wait);
		
		Assert.assertEquals(product.getItemName(), itemName);
		Assert.assertEquals(product.getCurrentColour(), "White");
		
		
	}

}
