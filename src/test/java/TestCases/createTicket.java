package TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import PageObjectFiles.CreateNewTicket;
import ReusableCode.BaseTestt;

public class createTicket extends BaseTestt {

	@Test
	public void runTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		CT = new CreateNewTicket(driver);
		CT.createNewTicket();
	
	}
}
