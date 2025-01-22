package HealthCare;

import java.io.IOException;


import com.fasterxml.jackson.databind.JsonNode;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatient {
    WebDriver driver;

    public RegisterPatient(WebDriver driver) {
        this.driver = driver;
    }

    public void Register() throws InterruptedException, IOException {
       
        JsonNode data = JsonReader.readJson("testdata/patientData.json");
        JsonNode patient = data.get("patient");

      
        String givenName = patient.get("givenName").asText();
        String middleName = patient.get("middleName").asText();
        String familyName = patient.get("familyName").asText();
        String gender = patient.get("gender").asText();
        String day = patient.get("birthDate").get("day").asText();
        String month = patient.get("birthDate").get("month").asText();
        String year = patient.get("birthDate").get("year").asText();
        String address1 = patient.get("address").get("address1").asText();
        String address2 = patient.get("address").get("address2").asText();
        String city = patient.get("address").get("city").asText();
        String state = patient.get("address").get("state").asText();
        String country = patient.get("address").get("country").asText();
        String postalCode = patient.get("address").get("postalCode").asText();
        String phone = patient.get("phone").asText();
        String relationType = patient.get("relationship").get("type").asText();
        String relationName = patient.get("relationship").get("name").asText();

     
        driver.findElement(By.xpath("//a[contains(@href, 'registerPatient')]")).click();

        driver.findElement(By.name("givenName")).sendKeys(givenName);
        driver.findElement(By.name("middleName")).sendKeys(middleName);
        driver.findElement(By.name("familyName")).sendKeys(familyName);
        driver.findElement(By.cssSelector("button[id='next-button']")).click();

       
        WebElement genderField = driver.findElement(By.id("gender-field"));
        new Select(genderField).selectByValue(gender);
        driver.findElement(By.cssSelector("button[id='next-button']")).click();

 
        driver.findElement(By.cssSelector("input[id='birthdateDay-field']")).sendKeys(day);
        WebElement monthDropdown = driver.findElement(By.cssSelector("select[id='birthdateMonth-field']"));
        new Select(monthDropdown).selectByValue(month);
        driver.findElement(By.cssSelector("input[id='birthdateYear-field']")).sendKeys(year);
        driver.findElement(By.cssSelector("button[id='next-button']")).click();

     
        driver.findElement(By.id("address1")).sendKeys(address1);
        driver.findElement(By.id("address2")).sendKeys(address2);
        driver.findElement(By.id("cityVillage")).sendKeys(city);
        driver.findElement(By.id("stateProvince")).sendKeys(state);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("postalCode")).sendKeys(postalCode);
        driver.findElement(By.cssSelector("button[id='next-button']")).click();

  
        driver.findElement(By.name("phoneNumber")).sendKeys(phone);
        driver.findElement(By.cssSelector("button[id='next-button']")).click();

    
        WebElement relationDropdown = driver.findElement(By.xpath("//select[@id='relationship_type']"));
        new Select(relationDropdown).selectByVisibleText(relationType);
        driver.findElement(By.xpath("//input[@placeholder='Person Name']")).sendKeys(relationName);
        driver.findElement(By.cssSelector("button[id='next-button']")).click();
        ScreenshotUtils.captureScreenshot(driver);
     
        driver.findElement(By.cssSelector(".submitButton")).click();

        Thread.sleep(2000);
        driver.navigate().to("https://demo.openmrs.org/openmrs/index.htm");
    }
}
