package HealthCare;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;


public class Logout {

	WebDriver driver;

	public Logout(WebDriver driver) {

		this.driver = driver;
	}

	public void LogoutApplication() throws InterruptedException {
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(@href, 'logout')]")).click();

	}

}
