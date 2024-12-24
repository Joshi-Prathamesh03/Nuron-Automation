package ReusableCode;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import Login.Login;
import PageObjectFiles.CreateNewTicket;

public class BaseTestt {
	public WebDriver driver;
	public Login log;
	public CreateNewTicket CT;

	Properties prop = new Properties();

	public WebDriver initDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeMethod()
	public Login hitURL() throws IOException {
		driver = initDriver();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(fis);
		String url = prop.getProperty("URL");
		driver.get(url);
		log = new Login(driver);
		log.login();
		return log;
	}
}
