package HealthCare;

import java.io.IOException;
import org.testng.annotations.Test;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class TestRun extends Basetest {

	@Test
	@Severity(SeverityLevel.NORMAL)
	public void TestExecution() throws InterruptedException, IOException {
		login ln = new login(driver);
		DateScheduling sd = new DateScheduling(driver);
		CreateAppoinment ap = new CreateAppoinment(driver);
		RegisterPatient pt = new RegisterPatient(driver);
		FindPatientRecord fp = new FindPatientRecord(driver);
		Logout lo = new Logout(driver);

		loginToSystem(ln);
		registerPatient(pt);
		scheduleDate(sd);
		bookAppointment(ap);
		findPatientRecord(fp);
		logoutOfSystem(lo);
	}

	@Step("Login to the OpenMRS system")
	public void loginToSystem(login ln) throws IOException {
		ln.loginOpenMRS();

	}

	@Step("Register a new patient")
	public void registerPatient(RegisterPatient pt) throws InterruptedException, IOException {
		pt.Register();

	}

	@Step("Schedule a date for the appointment")
	public void scheduleDate(DateScheduling sd) throws InterruptedException, IOException {
		sd.manageScheduling();

	}

	@Step("Book the appointment for the patient")
	public void bookAppointment(CreateAppoinment ap) throws InterruptedException, IOException {
		ap.BookAppoinmnet();
		ap.BookServices();

	}

	@Step("Find the patient record")
	public void findPatientRecord(FindPatientRecord fp) throws InterruptedException, IOException {
		fp.FindPatient();

	}

	@Step("Logout from the application")
	public void logoutOfSystem(Logout lo) throws InterruptedException, IOException {
		lo.LogoutApplication();

	}
}
