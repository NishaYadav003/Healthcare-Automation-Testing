package HealthCare;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Basetest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {

			driver.quit();

		}

	}

}
