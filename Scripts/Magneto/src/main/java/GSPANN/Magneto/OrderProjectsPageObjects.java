package GSPANN.Magneto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderProjectsPageObjects {

	WebDriver driver;

	public OrderProjectsPageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Hero Hoodie']")
	WebElement desiredProduct;

	@FindBy(xpath = "//div[@option-label='XL']")
	WebElement desiredSize;

	@FindBy(xpath = "//div[@class='swatch-option color'][2]")
	WebElement desiredColor;

	@FindBy(id = "qty")
	WebElement updateQuantity;

	@FindBy(id = "product-addtocart-button")
	WebElement addToCartButton;

	@FindBy(css = ".action.showcart")
	WebElement cartIcon;

	@FindBy(id = "top-cart-btn-checkout")
	WebElement proceedTocheckout;

	@FindBy(xpath = "//input[@name='company']")
	WebElement company;

	@FindBy(xpath = "//input[@name='street[0]']")
	WebElement address;

	@FindBy(xpath = "//input[@name='city']")
	WebElement city;
	//
	@FindBy(xpath = "//select[@name='region_id']")
	WebElement state;

	@FindBy(xpath = "//input[@name='postcode']")
	WebElement ZipCode;

	@FindBy(xpath = "//select[@name='country_id']")
	WebElement country;

	// telephone
	@FindBy(xpath = "//input[@name='telephone']")
	WebElement phoneNumber;

	@FindBy(xpath = "//input[@name='ko_unique_2']")
	WebElement shippingMethod;

	@FindBy(css = "button.action.continue.primary")
	WebElement nextbutton;

	@FindBy(xpath = "//button[@class='action action-show-popup']")
	WebElement AddnewAddress;

	@FindBy(id = "shipping-save-in-address-book")
	WebElement shippingAddressCheckbox;

	@FindBy(xpath = "//button[@class='action primary action-save-address']")
	WebElement shipHereButton;

	@FindBy(xpath = "//button[@title='Place Order']")
	WebElement placeOrderButton;

	@FindBy(xpath = "//a[@class='order-number']")
	WebElement orderNumber;

	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	WebElement myAccounticon;

	@FindBy(linkText = "My Account")
	WebElement myAccountLink;
	
	@FindBy(xpath = "(//a[normalize-space()='My Wish List'])[1]")
	WebElement myWishListLink;

	@FindBy(linkText = "My Orders")
	WebElement MyOrdersLink;

	@FindBy(xpath = "//td[@class='col id']")
	WebElement OrderNumberVerify;

	@FindBy(xpath = "//div[@data-ui-id='checkout-cart-validationmessages-message-error']")
	WebElement errorMessage;
	
	@FindBy (id = "block-discount-heading")
	WebElement applyDiscountLink;
	
	@FindBy (xpath ="//input[@id='discount-code']")
	WebElement enterDiscountCode;
	
	@FindBy (xpath ="//button[@value='Apply Discount']")
	WebElement applyDiscountConfirm;
	

}
