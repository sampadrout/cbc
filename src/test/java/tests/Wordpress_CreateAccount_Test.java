/*
 * @author Ajith H

 * (C) Copyright 2021 by Accion Labs Inc.
 */
package tests;

import java.util.Map;

import com.ui.core.framework.db.testng.TestNGMongoDataProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.core.framework.db.annotations.GetDataFromMongo;
import com.ui.core.framework.base.BaseTest;
import com.ui.core.framework.reporting.TestListener;

import poms.CreateAccountPage;
import poms.HomePage;

@Listeners({ TestListener.class })
public class Wordpress_CreateAccount_Test extends BaseTest {

	@GetDataFromMongo(dbName = "accel_Zoho", collectionName = "environment_ui", appName = "accel_Zoho", envName = "environment", tcName = "TC01", dataType = "testcaseData")
	@Test(description = "Wordpress Sample Create Account Test", dataProviderClass = TestNGMongoDataProvider.class, dataProvider = "dataProviderMongo")
	public void testSampleWordPressAccount(Map<String, String> data) throws Exception {

		page.getPageInstance(HomePage.class).navigateTo(data.get("url"));
		Assert.assertTrue(page.getPageInstance(HomePage.class).verifyWordPressPageDisplayed(), "The Wordpress Homepage has not displayed...");
		
		page.getPageInstance(HomePage.class).clickStartYourSite();
		Assert.assertTrue(page.getPageInstance(CreateAccountPage.class).verifyCreateAccountPageDisplayed(), "Create Your Account Page has not Displayed...");

		page.getPageInstance(CreateAccountPage.class).createUserAccount(data);
	}
}