package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Search;

public class BusquedaTest extends TestsCommon {
	
	@Test
	public void busquedaExistente() {
		
		pagesCommon.search("Printed Dress");
		
		
		Search search =  new Search(driver, wait);
		
		Assert.assertNotEquals(search.searchResult(), "0 results have been found.");
		Assert.assertTrue(search.itemFound("Printed Dress"));
		
	}
	
	@Test
	public void busquedaNoExistente() {
		
		pagesCommon.search("Pants");
		
		
		Search search =  new Search(driver, wait);
		
		Assert.assertEquals(search.searchResult(), "0 results have been found.");
		
	}

}
