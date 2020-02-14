package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Category;

public class DropdownsTest extends TestsCommon {

	private Category category;
	
	@BeforeMethod
	public void getReady() {
		pagesCommon.goToCategory("T-shirts");
		
		category = new Category(driver, wait);
	}

	@Test(description = "Test de Dropdowns - opcion -- ")
	public void option1() {
		Assert.assertEquals(category.sortResults(1), category.getExpectedOrder(1));
	}
	@Test(description = "Test de Dropdowns - opcion Price Lowest first ")
	public void option2() {
		Assert.assertEquals(category.sortResults(2), category.getExpectedOrder(2));
	}
	@Test(description = "Test de Dropdowns - opcion Price Highest first ")
	public void option3() {
		Assert.assertEquals(category.sortResults(3), category.getExpectedOrder(3));
	}
	@Test(description = "Test de Dropdowns - opcion Product Name A to Z ")
	public void option4() {
		Assert.assertEquals(category.sortResults(4), category.getExpectedOrder(4));
	}
	@Test(description = "Test de Dropdowns - opcion Product Name Z to A ")
	public void option5() {
		Assert.assertEquals(category.sortResults(5), category.getExpectedOrder(5));
	}
	@Test(description = "Test de Dropdowns - opcion In stock ")
	public void option6() {
		Assert.assertEquals(category.sortResults(6), category.getExpectedOrder(6));
	}
	@Test(description = "Test de Dropdowns - opcion Reference Lowest first ")
	public void option7() {
		Assert.assertEquals(category.sortResults(7), category.getExpectedOrder(7));
	}
	@Test(description = "Test de Dropdowns - opcion Reference Highest first ")
	public void option8() {
		Assert.assertEquals(category.sortResults(8), category.getExpectedOrder(8));
	}
	
}
