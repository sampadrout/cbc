package poms;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.core.framework.base.BasePage;
import com.ui.core.framework.utilities.Wait;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class LandingPage extends BasePage {

	@FindBy(xpath = "//strong[contains(text(),'Welcome!')]")
	private WebElement lbl_LandingPageTitle;

	@FindBy(xpath = "//span/img[@class='gravatar']")
	private WebElement btn_MyProfile;

	@FindBy(xpath = "//button[@title='Log out of WordPress.com']")
	private WebElement btn_LogoutButton;

	@FindBy(xpath = "//button[@class='button form-button is-primary'][contains(text(),'Continue')]")
	private WebElement btn_Continue;
	
	@FindBy(xpath = "//button[@class='button form-button is-primary'][contains(text(),'Log In')]")
	private WebElement btn_Login;
	
	Wait wait = new Wait();

	public LandingPage(WebDriver driver) throws InterruptedException {
		super(driver);
	}

	@Step("Verify 'Landing' page displayed...")
	public boolean verifyLandingPageDisplayed() throws Exception {
		if(getLabel(wait.waitForElementToBeVisible(lbl_LandingPageTitle, webdriver)).contains("Welcome!")) {
			Allure.step("Landing Page is displayed...");
			return true;
		}
		Allure.step("Landing Page is not displayed...");
		return false;
	}

	@Step("Logout from the account...")
	public void logout() throws Exception {
		click(wait.waitForElementToBeClickable(btn_MyProfile, webdriver));
		wait.staticWait(2000);
		click(wait.waitForElementToBeClickable(btn_LogoutButton, webdriver));
		wait.staticWait(2000);
	}

}
