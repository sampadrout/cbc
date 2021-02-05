/*
 * @author Ajith H

 * (C) Copyright 2019 by Accion Labs Inc.
 */
package tests;

import java.util.Map;

import com.ui.core.framework.db.testng.TestNGMongoDataProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.core.framework.base.BaseTest;
import com.ui.core.framework.db.annotations.GetDataFromMongo;
import com.ui.core.framework.reporting.TestListener;

import poms.HomePage;
import poms.LandingPage;
import poms.LoginAccountPage;

@Listeners({ TestListener.class })
public class Wordpress_Login_Test extends BaseTest {
	
	@GetDataFromMongo(dbName = "accel_Zoho", collectionName = "environment_ui", appName = "accel_Zoho", envName = "environment", tcName = "TC02", dataType = "testcaseData")
	@Test(description = "Wordpress Valid_Login Test", priority=1, dataProviderClass = TestNGMongoDataProvider.class, dataProvider = "dataProviderMongo")
	public void testValidLogin(Map<String, String> data) throws Exception {

		page.getPageInstance(HomePage.class).navigateTo(data.get("url"));
		Assert.assertTrue(page.getPageInstance(HomePage.class).verifyWordPressPageDisplayed(), "The Wordpress Homepage has not displayed...");
		
		page.getPageInstance(HomePage.class).clickLoginButton();
		Assert.assertTrue(page.getPageInstance(LoginAccountPage.class).verifyLoginAccountPageDisplayed(), "'Login into your account' Page has not Displayed...");

		page.getPageInstance(LoginAccountPage.class).login(data);
		Assert.assertTrue(page.getPageInstance(LandingPage.class).verifyLandingPageDisplayed(), "Login is Unsuccessful...");

		page.getPageInstance(LandingPage.class).logout();
		Assert.assertTrue(page.getPageInstance(HomePage.class).verifyWordPressPageDisplayed(), "The Wordpress Homepage has not displayed...");
	}
	
	@GetDataFromMongo(dbName = "accel_Zoho", collectionName = "environment_ui", appName = "accel_Zoho", envName = "environment", tcName = "TC03", dataType = "testcaseData")
	@Test(description = "Wordpress Invalid_Login Test", priority=2, dataProviderClass = TestNGMongoDataProvider.class, dataProvider = "dataProviderMongo")
	public void testInvalidLogin(Map<String, String> data) throws Exception {

		page.getPageInstance(HomePage.class).navigateTo(data.get("url"));
		Assert.assertTrue(page.getPageInstance(HomePage.class).verifyWordPressPageDisplayed(), "The Wordpress Homepage has not displayed...");
		
		page.getPageInstance(HomePage.class).clickLoginButton();
		Assert.assertTrue(page.getPageInstance(LoginAccountPage.class).verifyLoginAccountPageDisplayed(), "'Login into your account' Page has not Displayed...");

		page.getPageInstance(LoginAccountPage.class).login(data);
		Assert.assertTrue(page.getPageInstance(LandingPage.class).verifyLandingPageDisplayed(), "Login is Unsuccessful...");

	}
}