package com.codenbox.MavenProject;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class NavigationBarTest extends Base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		// log.info("Driver is initialize");
		driver.get(prop.getProperty("url"));
		// driver.get("google.com);
		// log.info("Navigate to home page");
	}

	@Test
	public void basePageNavigationBar() {
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		// log.info("Top navigation bar is displaying");
	}

	@Test
	public void dropDownSelect() throws InterruptedException {
		LandingPage l = new LandingPage(driver);
		Thread.sleep(4000L);
		Select s = new Select(l.getDropDown());
		s.selectByValue("option1");
		Assert.assertTrue(l.getDropDown().isDisplayed());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null; // All the objects are alive in memory that can full. So clean memory.
	}

}
