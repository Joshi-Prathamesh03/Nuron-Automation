package PageObjectFiles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewTicket {

	WebDriver driver;

	public CreateNewTicket(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[normalize-space()='Ticket']")
	WebElement ticketLink;

	@FindBy(css = ".icon.icon-tabler.icon-tabler-plus")
	WebElement addButton;

	@FindBy(name = "displayName")
	WebElement title;

	@FindBy(xpath = "//textarea[@name='description']")
	WebElement description;

	@FindBy(css = "textarea[placeholder='Acceptance Criteria']")
	WebElement acceptanceCriteria;

	@FindBy(xpath = "//span[contains(text(),'Role')]")
	WebElement assignToTypeRadio;

	@FindBy(css = "#assignedToUserIDs-id")
	private WebElement assignTodropdown;

	@FindBy(xpath = "//li[@role='option']")
	private List<WebElement> assignToDropdownOptions;

	@FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-l86k8m'][normalize-space()='Critical']")
	WebElement severity;

	@FindBy(name = "dueDate")
	WebElement dueDate;

	@FindBy(id = "status-id")
	WebElement status;

	@FindBy(id = "category-id")
	WebElement category;

	@FindBy(css = "input[placeholder='Root Cause']")
	WebElement rootCause;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveBtn;

	private void selectDropdownOption(Actions action, int downPressCount) {

		for (int i = 0; i < downPressCount; i++) {
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.DOWN).perform();
		}
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public void createNewTicket() throws InterruptedException {
		ticketLink.click();
		addButton.click();
		title.sendKeys("My ticket");
		description.sendKeys("Ticket Description");
		acceptanceCriteria.sendKeys("myAcceptanceCriteria");
		assignToTypeRadio.click();
		Actions action = new Actions(driver);
		// Selecting Assign To
		selectDropdownOption(action, 1);

		severity.click();
		dueDate.sendKeys("11/13/2024");
//		// Selecting Status
		selectDropdownOption(action, 2);
////		//Selecting Category
		selectDropdownOption(action, 1);

//
//		// Selecting subCategory
		selectDropdownOption(action, 1);

		rootCause.sendKeys("Ticket Root Cause");
		saveBtn.click();

	}
	public void horizontalScroll() {
		
	}

	

}
