package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.base.BaseTest;
import com.ui.constants.Users;
import com.ui.pages.LandingPage;
import com.ui.utilities.DataProviders;

@Listeners(com.ui.listeners.MyUITestListener.class)

public class SUPTest extends BaseTest {

	@Test(groups = { "smoke", "regression" }, description = "SUP user login to application")
	public void loginSUP() {

		LandingPage landingPage = new LandingPage(getDriver());
		String url = landingPage.loadurl().enterUserName(String.valueOf(Users.SUP))
				.enterPassword(String.valueOf(Users.SUP)).clickSignIn().geturl();
		Assert.assertTrue(url.contains("supervisor/dashboard"));
	}

	@Test(groups = {
			"regression" }, dataProvider = "PendingJobAssignment", dataProviderClass = DataProviders.class, description = "SUP user search job")
	public void searchJob(String id, String oem) {
		LandingPage landingPage = new LandingPage(getDriver());
		landingPage.loadurl().enterUserName(String.valueOf(Users.SUP)).enterPassword(String.valueOf(Users.SUP))
				.clickSignIn().clickSearchJobImei(id);
	}

}
