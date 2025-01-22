package HealthCare;

import java.io.IOException;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class login {

	WebDriver driver;

	// Constructor to receive WebDriver
	public login(WebDriver driver) {
        this.driver = driver;
    }

	public void loginOpenMRS() throws IOException {

		String username = "admin";
		String password = "Admin123";
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.findElement(By.name("username")).sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("Pharmacy")).click();
		ScreenshotUtils.captureScreenshot(driver);
		driver.findElement(By.cssSelector(".btn.confirm")).click();
	}

}
