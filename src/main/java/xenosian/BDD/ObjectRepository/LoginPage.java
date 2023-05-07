package xenosian.BDD.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Ratan
 *
 */
public class LoginPage {

	@FindBy(name = "user_name")
	private WebElement usernametext;
	
	@FindBy(name = "user_password")
	private WebElement passwordtext;
	
	@FindBy(id = "submitButton")
	private WebElement submitButton;

	public WebElement getUsernametext() {
		return usernametext;
	}

	public WebElement getPasswordtext() {
		return passwordtext;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * Business Library
	 * 
	 * this method will login to app
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password) {
		usernametext.sendKeys(username);
		passwordtext.sendKeys(password);
		
	}
	public void clickOnSubmit() {
		submitButton.click();
	}
}
