package GSPANN.Magneto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoWishListPageObjects {

	WebDriver driver;

	public AddtoWishListPageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement signInLink;

	@FindBy(linkText = "Create an Account")
	WebElement createAnAccountLink;

	@FindBy(id = "email")
	WebElement emailID;

	@FindBy(id = "pass")
	WebElement crpassword;

	@FindBy(id = "send2")
	WebElement SignInbutton;

	public void signIntoApplication(String mail, String password) {
		signInLink.click();
		emailID.sendKeys(mail);
		crpassword.sendKeys(password);
		SignInbutton.click();
	}

	public void goTo() {

		driver.get("https://magento.softwaretestingboard.com/");
	}

	@FindBy(linkText = "store logo")
	WebElement storelogo;

	@FindBy(xpath = "//a[normalize-space()='Radiant Tee']")
	WebElement productName;

	@FindBy(xpath = "//span[normalize-space()='Add to Wish List']")
	WebElement addToWishList;

	@FindBy(xpath = "//div[@class='message-success success message']")
	WebElement successMessage;

	@FindBy(xpath = "//div[@data-container='product-grid']")
	WebElement addedProduct;

	@FindBy(xpath = "//a[@title='Remove Item']")
	WebElement removeProduct;
	
	@FindBy (linkText = "shopping cart")
	WebElement shoppingCartLink;
	
	@FindBy(xpath = "//span[normalize-space()='Move to Wishlist']")
	WebElement moveToWishList;
	
	@FindBy (xpath = "//div[@class='cart-empty'][1]")
	WebElement clearMessage;
	
	
	

}
