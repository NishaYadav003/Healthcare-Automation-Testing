package HealthCare;

import java.io.IOException;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DateScheduling {
	WebDriver driver;

	// Constructor to initialize WebDriver
	public DateScheduling(WebDriver driver) {
		this.driver = driver;

		
	}

	public void manageScheduling() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//a[@href='/openmrs//appointmentschedulingui/home.page']")).click();
		driver.findElement(By.xpath("//a[@href='/openmrs/appointmentschedulingui/scheduleProviders.page']")).click();
		Thread.sleep(2000);
		WebElement inputBox = driver.findElement(By.xpath("//input[@ng-model='providerFilter']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(inputBox).click().sendKeys("Su").build().perform();
		Thread.sleep(2000);
		List<WebElement> doctor = driver.findElements(
				By.cssSelector(".dropdown-menu.ng-isolate-scope"));

		for (WebElement doctors : doctor) {
			String doctorName = doctors.getText();
			if (doctorName.equalsIgnoreCase("Super User")) {
				System.out.println("Doctor Found: " + doctorName);
				doctors.click();
			}
		}
		
		driver.findElement(By.cssSelector("span[class='fc-button fc-button-next fc-state-default fc-corner-right'] span:nth-child(1)")).click();
		String year = "2025";
		String month = "02";
		String date = "11";

		// Constructing the XPath dynamically
		String xpath = "//td[@data-date='" + year + "-" + month + "-" + date + "']";
		ScreenshotUtils.captureScreenshot(driver);
		// Clicking the specific date
		driver.findElement(By.xpath(xpath)).click();
		
	}
}
