package com.codenbox.MavenProject;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginPageTest extends Base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		// log.info("Driver is initialize");
		driver.get(prop.getProperty("url"));
		// log.info("Navigate to home page");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password) throws IOException, InterruptedException {
		LandingPage l = new LandingPage(driver);
		// log.debug("Click on login button");
		//l.getLogin().click();
		l.getLogin().sendKeys(Keys.ENTER);
		// log.info("Navigate to login page");
		Thread.sleep(8000L);
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		//lp.getLogin().click();
		lp.getLogin().sendKeys(Keys.ENTER);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null; // All the objects are alive in memory that can full. So clean memory.
	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types/set test should run
		// Column stands how many different values for each type/set test
		Object[][] data = new Object[1][2];
		// 0th row
		data[0][0] = "test@test.com";
		data[0][1] = "123456";
		// 1st row
		/*
		 * data[1][0]="test2@test.com"; data[1][1]="1234561!";
		 */
		return data;
	}

}
