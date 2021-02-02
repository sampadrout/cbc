package poms;



import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.core.framework.base.BasePage;
import com.ui.core.framework.utilities.Wait;

import io.qameta.allure.Step;

public class LoginAccountPage extends BasePage {

	@FindBy(xpath = "//div[@class='login__form-header']")
	private WebElement lbl_LoginAccountPageTitle;

	@FindBy(xpath = "//input[@id='usernameOrEmail']")
	private WebElement txt_EmailAddress;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement txt_Password;

	@FindBy(xpath = "//button[@class='button form-button is-primary'][contains(text(),'Continue')]")
	private WebElement btn_Continue;
	
	@FindBy(xpath = "//button[@class='button form-button is-primary'][contains(text(),'Log In')]")
	private WebElement btn_Login;
	
	@FindBy(xpath = "//input[@id='password']/../../div[2]/span")
	private WebElement lbl_InvalidPasswordErrorMsg;
	
	Wait wait = new Wait();

	public LoginAccountPage(WebDriver driver) throws InterruptedException {
		super(driver);
	}

	@Step("Verify 'Login into your account' page displayed...")
	public boolean verifyLoginAccountPageDisplayed() throws Exception {
		if(getLabel(wait.waitForElementToBeVisible(lbl_LoginAccountPageTitle, webdriver)).contains("Log in to your account")) {
			return true;
		}
		return false;
	}

	@Step("Enter Credentials & Login...")
	public void login(Map<String, String> data) throws Exception {
		type(wait.waitForElementToBeClickable(txt_EmailAddress, webdriver), data.get("emailAddress"));
		wait.staticWait(2000);
		click(wait.waitForElementToBeClickable(btn_Continue, webdriver));
		wait.staticWait(2000);
		
		type(wait.waitForElementToBeClickable(txt_Password, webdriver), data.get("password"));
		wait.staticWait(2000);
		click(wait.waitForElementToBeClickable(btn_Login, webdriver));
	}
	
	@Step("Verify Invalid Password Error Message...")
	public boolean verifyInvalidPasswordErrorMsg() throws Exception {
		return checkElement(wait.waitForElementToBeVisible(lbl_InvalidPasswordErrorMsg, webdriver));
	}

}
