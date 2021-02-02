package poms;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.core.framework.base.BasePage;
import com.ui.core.framework.utilities.Wait;

import io.qameta.allure.Step;

public class HomePage extends BasePage {

	@FindBy(className = "(//h1/span)[1]")
	private WebElement lbl_HomepageHeader;

	@FindBy(xpath = "//a[@id='lpc-button']")
	private WebElement btn_StartYourSite;
	
	@FindBy(xpath = "//li[@class='x-nav-item x-nav-item--wide']/a[@title='Log In']")
	private WebElement btn_LoginButton;

	Wait wait = new Wait();

	public HomePage(WebDriver driver) throws InterruptedException {
		super(driver);
	}
	
	@Step("Navigate to page step...")
	public void navigateTo(String url) throws Exception {
		gotoURL(url);
	}

	@Step("Verify WordPress HomePage displayed")
	public boolean verifyWordPressPageDisplayed() throws Exception {
		return checkElement(btn_StartYourSite);
	}
	
	@Step("Click on the 'Start Your Site Button'")
	public void clickStartYourSite() {
		click(wait.waitForElementToBeClickable(btn_StartYourSite, webdriver));
	}
	
	@Step("Click on the Login Button'")
	public void clickLoginButton() {
		click(wait.waitForElementToBeClickable(btn_LoginButton, webdriver));
	}

}