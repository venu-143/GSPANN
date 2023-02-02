package GSPANN.Magneto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createAccountPageObjects {

	WebDriver driver;

	public createAccountPageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstname")
	WebElement customeFirstName;

	@FindBy(id = "lastname")
	WebElement customeLastName;

	@FindBy(id = "is_subscribed")
	WebElement checkNewspaperSubscription;

	@FindBy(id = "email_address")
	WebElement customerMailId;

	@FindBy(id = "password")
	WebElement customerpassword;

	@FindBy(id = "password-confirmation")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@title='Create an Account']")
	WebElement createAccountButton;

	@FindBy(xpath = "//div[@class='message-success success message']")
	WebElement successMessage;

}
