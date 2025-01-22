package HealthCare;

import java.io.IOException;
import java.util.List;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CreateAppoinment {

	WebDriver driver;

	public CreateAppoinment(WebDriver driver) {

		this.driver = driver;

	}

	public void BookAppoinmnet() {

		WebElement startTime = driver.findElement(By.xpath("//div[@id='start-time']//input[@ng-model='hours']"));
		startTime.clear();
		startTime.sendKeys("09");
	}

	public void BookServices() throws InterruptedException, IOException {

		driver.findElement(By.xpath("//input[@id='createAppointmentBlock']")).sendKeys("Der");

		Thread.sleep(2000);
		List<WebElement> services = driver.findElements(By.cssSelector(".dropdown-menu.ng-isolate-scope"));

		for (WebElement service : services) {

			String sname=service.getText().trim();
			if (sname.contains("Dermatology")){

				service.click();
			}

		}
		
		driver.findElement(By.xpath("//button[@ng-click='saveAppointmentBlock()']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".fc-event-title")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@ng-click='showDeleteAppointmentBlockModal()']")).click();		
		
		 ScreenshotUtils.captureScreenshot(driver);
		
		driver.findElement(By.cssSelector("span[class='button confirm']")).click();
		
		driver.navigate().to("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
		
		

	}

}
