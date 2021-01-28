package poms;



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
		if(getLabel(wait.waitForElementToBeVisible(lbl_CreateAccountPageTitle, webdriver)).contains("vfbfbfgbfg")) {
			Allure.step("WordPress Create Account page has displayed...");
			return true;
		}
		Allure.step("WordPress Create Account page has not displayed...");
		return false;
	}

	@Step("Create New Wordpress user account...")
	public void createUserAccount() throws Exception {
		type(txt_EmailAddress, "cbc_sample@test.com");
		wait.staticWait(2000);
		type(txt_Username, "cbc_sample");
		wait.staticWait(2000);
		type(txt_Password, "New@123_");
		wait.staticWait(2000);
		click(btn_CreateAccount);
		wait.staticWait(2000);
	}

}
