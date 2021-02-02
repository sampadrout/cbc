package poms;



import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.core.framework.base.BasePage;
import com.ui.core.framework.utilities.Wait;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class CreateAccountPage extends BasePage {

	@FindBy(xpath = "//h1[@class='formatted-header__title']")
	private WebElement lbl_CreateAccountPageTitle;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement txt_EmailAddress;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement txt_Username;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement txt_Password;

	@FindBy(xpath = "//button[@class='button signup-form__submit form-button is-primary']")
	private WebElement btn_CreateAccount;
	
	Wait wait = new Wait();

	public CreateAccountPage(WebDriver driver) throws InterruptedException {
		super(driver);
	}

	@Step("Verify 'Create Your Account' page displayed")
	public boolean verifyCreateAccountPageDisplayed() throws Exception {
		if(getLabel(wait.waitForElementToBeVisible(lbl_CreateAccountPageTitle, webdriver)).contains("Let's get")) {
			Allure.step("WordPress Create Account page has displayed...");
			return true;
		}
		Allure.step("WordPress Create Account page has not displayed...");
		return false;
	}

	@Step("Create New Wordpress user account...")
	public void createUserAccount(Map<String, String> data) throws Exception {
		type(txt_EmailAddress, data.get("emailAddress"));
		wait.staticWait(2000);
		type(txt_Username, data.get("userName"));
		wait.staticWait(2000);
		type(txt_Password, data.get("password"));
		wait.staticWait(2000);
		click(btn_CreateAccount);
	}

}
