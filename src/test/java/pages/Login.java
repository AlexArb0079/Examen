package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends PagesCommon {
	
	private By email;
	private By password;
	private By signinButton;
	private By signinError;
	

	public Login(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		email = By.id("email");
		password = By.id("passwd");
		signinButton = By.id("SubmitLogin");
		signinError = By.xpath("//*[@id=\"center_column\"]//li");
	}
	
	public String login(String user, String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signinButton).click();
		
		return driver.findElement(signinError).getAttribute("innerText");
	}

}
