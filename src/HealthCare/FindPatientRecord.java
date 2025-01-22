package HealthCare;

import java.io.IOException;
import java.time.Duration;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindPatientRecord {

	WebDriver driver;

	public FindPatientRecord(WebDriver driver) {

		this.driver = driver;

	}

	public void FindPatient() throws InterruptedException, IOException {

		String patientName = "John Jake Smith";

		driver.findElement(
				By.xpath("//a[@href='/openmrs/coreapps/findpatient/findPatient.page?app=coreapps.findPatient']"))
				.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("input[id='patient-search']")).sendKeys(patientName);

		List<WebElement> pnames = driver.findElements(By.xpath("//tr/td[2]"));

		for (WebElement pname : pnames) {
			try {
				String patient = pname.getText();
				if (patient.equalsIgnoreCase(patientName)) {
					pname.click(); // Click on the correct patient
					break; // Stop loop after finding the correct patient
				}
			} catch (StaleElementReferenceException e) {
				// Re-locate elements if stale
				pnames = driver.findElements(By.xpath("//tr/td[2]"));
			}
		}

		// Wait for the delete button and click
		WebElement deleteButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//ul//div[contains(text(), 'Delete Patient')]")));
		deleteButton.click();

		WebElement reasonBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='delete-reason']")));
		reasonBox.sendKeys("Duplicate Account");

		WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@id='delete-patient-creation-dialog']//button[contains(@class, 'confirm')]")));
		ScreenshotUtils.captureScreenshot(driver);
		confirmButton.click();
	}

}