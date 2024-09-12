package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.base.BaseTest;
import com.ui.constants.Users;
import com.ui.objects.CreateJobPOJO;
import com.ui.pages.DashboardPageFD;
import com.ui.pages.LandingPage;
import com.ui.utilities.FakerUtil;

@Listeners(com.ui.listeners.MyUITestListener.class)
public class FDTest extends BaseTest {

	@Test(groups = { "smoke", "regression" }, description="FD user login to application")
	public void loginFD() {
		logger.info("FD user login to application");
		LandingPage landingPage = new LandingPage(getDriver());

		String url = landingPage.loadurl().enterUserName(String.valueOf(Users.FD))
				.enterPassword(String.valueOf(Users.FD)).clickSignIn().geturl();

		Assert.assertTrue(url.contains("frontdesk/dashboard1"));
	}

	@Test(groups = { "regression" }, description="FD user create job")
	public void createJob() throws InterruptedException {

		FakerUtil fakerUtil = new FakerUtil();
		String fname = fakerUtil.randomFirstName();
		String lname = fakerUtil.randomLastName();
		String email = fname + lname + "@test.com";

		logger.info("FD user login to application");

		LandingPage landingPage = new LandingPage(getDriver());

		CreateJobPOJO data = new CreateJobPOJO(fakerUtil.randomIMEI(), fname, lname, fakerUtil.randomContact(), email);

		landingPage.loadurl().enterUserName(String.valueOf(Users.FD)).enterPassword(String.valueOf(Users.FD))
				.clickSignIn();

		DashboardPageFD dashboardPageFD = new DashboardPageFD(getDriver());

		logger.info("FD user create job");

		Assert.assertTrue(dashboardPageFD.clickCreateJOb().createJob(data).submitButton(),
				"Submit button not displayed");

	}

}
