package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.base.BasePage;
import com.ui.utilities.ConfigLoader;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	private static final By USERNAME = By.id("username");
	private static final By PASSWORD = By.id("password");
	private static final By SIGN_IN = By.xpath("//span[contains(text(),'Sign in')]");

	public LandingPage loadurl() {
		load("sign-in");
		return this;
	}

	public LandingPage enterUserName(String user) {
		driver.findElement(USERNAME).clear();
		driver.findElement(USERNAME).sendKeys(ConfigLoader.getInstance().getUsername(user));
		return this;
	}

	public LandingPage enterPassword(String user) {
		driver.findElement(PASSWORD).clear();
		driver.findElement(PASSWORD).sendKeys(ConfigLoader.getInstance().getPassword(user));
		return this;
	}

	public DashboardPage clickSignIn() {
		driver.findElement(SIGN_IN).click();
		return new DashboardPage(driver);
	}
}
