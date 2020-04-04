package com.codenbox.MavenProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidTitleTest extends Base {

	@Test
	public void basePageTitle() throws IOException {
		driver = initializeDriver();
		// log.info("Driver is initialize");
		driver.get(prop.getProperty("url"));
		// log.info("Navigate to home page");
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "Automation Practice");
		// log.info("Successfully validate Text message");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null; // All the objects are alive in memory that can full. So clean memory.
	}

}
