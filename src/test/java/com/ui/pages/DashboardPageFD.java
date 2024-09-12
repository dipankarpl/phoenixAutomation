package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.base.BasePage;

public class DashboardPageFD extends BasePage {

	public DashboardPageFD(WebDriver driver) {
		super(driver);
	}

	private static final By CREATE_JOB = By.xpath("//span[normalize-space()='Create Job']");

	public CreateJobPage clickCreateJOb() {
		driver.findElement(CREATE_JOB).click();
		return new CreateJobPage(driver);
	}
}
