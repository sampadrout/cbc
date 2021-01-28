/*
 * @author Ajith H

 * (C) Copyright 2019 by Accion Labs Inc.
 */
package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.core.framework.base.BaseTest;
import com.ui.core.framework.reporting.TestListener;

import poms.CreateAccountPage;
import poms.HomePage;

@Listeners({ TestListener.class })
public class Wordpress_Sample_Test extends BaseTest {

	@Test(description = "Wordpress Sample Test")
	public void testSampleWordPress() throws Exception {

		page.getPageInstance(HomePage.class).navigateTo("https://www.wordpress.com");
		Assert.assertTrue(page.getPageInstance(HomePage.class).verifyWordPressPageDisplayed(), "The Wordpress Homepage has not displayed...");
		
		page.getPageInstance(HomePage.class).clickStartYourSite();
		Assert.assertTrue(page.getPageInstance(CreateAccountPage.class).verifyCreateAccountPageDisplayed(), "Create Your Account Page has not Displayed...");

		page.getPageInstance(CreateAccountPage.class).createUserAccount();
	}
}