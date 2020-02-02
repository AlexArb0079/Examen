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

	@Test
	public void option1() {
		Assert.assertEquals(category.sortResults(1), category.getCurrentOrder());
	}
	@Test
	public void option2() {
		Assert.assertEquals(category.sortResults(2), category.getCurrentOrder());
	}
	@Test
	public void option3() {
		Assert.assertEquals(category.sortResults(3), category.getCurrentOrder());
	}
	@Test
	public void option4() {
		Assert.assertEquals(category.sortResults(4), category.getCurrentOrder());
	}
	@Test
	public void option5() {
		Assert.assertEquals(category.sortResults(5), category.getCurrentOrder());
	}
	@Test
	public void option6() {
		Assert.assertEquals(category.sortResults(6), category.getCurrentOrder());
	}
	@Test
	public void option7() {
		Assert.assertEquals(category.sortResults(7), category.getCurrentOrder());
	}
	@Test
	public void option8() {
		Assert.assertEquals(category.sortResults(8), category.getCurrentOrder());
	}
	
}
