package Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	Properties prop = new Properties();

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#outlined-adornment-email-login")
	WebElement userName;

	@FindBy(css = "#outlined-adornment-password-login")
	WebElement password;

	@FindBy(css = "Button[type='submit']")
	WebElement signIn;

	public void login() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\ src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(fis);
		String nuronUserName = prop.getProperty("username");
		String nuronUserPassword = prop.getProperty("password");

		userName.sendKeys(nuronUserName);
		password.sendKeys(nuronUserPassword);
		signIn.click();
	}

}
