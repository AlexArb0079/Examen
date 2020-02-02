package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login;

public class AutenticacionTest extends TestsCommon {
	
	@Test
	public void AutenticationFailed() {
		
		pagesCommon.signIn();
		Login logIn =  new Login(driver, wait);
		Assert.assertEquals(logIn.login("alexis.colman@arbusta.net", "123456"), "Authentication failed.");
		
		
	}
}
