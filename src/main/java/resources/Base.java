package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public static Properties prop;

	// method to initialize driver
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\reazb\\Desktop\\SeleniumTraining\\MavenProject\\MavenProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\reazb\\Desktop\\SeleniumTraining\\SeleniumProject\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\reazb\\Desktop\\SeleniumTraining\\SeleniumProject\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		return driver;
	}

	public void getScreenshot(String result) throws IOException {
		// Web Driver take the screenshot as a file and save in virtually in src
		// variable.
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// copy the file from src and put in your local machine with the name of failed
		// test class
		FileUtils.copyFile(srcFile, new File("C://screenshotTest//" + result + "screenshot.png"));
	}

}
