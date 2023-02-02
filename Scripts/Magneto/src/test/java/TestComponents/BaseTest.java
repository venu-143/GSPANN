package TestComponents;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GSPANN.Magneto.AddtoWishListPageObjects;

public class BaseTest {
	public WebDriver driver;

	public String FirstName = "Roshan";
	public String LastName = "Raj";
	public String emailFirst = "vignesh";
	public String emailLast = "@gmail.com";
	public String customerPassword = "StrongPassword@2022";
	public String confirmPassword = "StrongPassword@2022";
	public String regEmailId = "vignesh2022@gmail.com";
	public String regPassword = "January_@2022";
	public String quantity = "2";
	public String company = "Logger Private Ltd";
	public String address = "24, Veer Road, Arasur";
	public String city = "Coimbatore";
	public String country = "India";
	public String state = "Tamil Nadu";
	public String zipCode = "611112";
	public String phoneNumber = "9876545678";
	public String testerName = "Tested By";
	public String testerValue = "vignesh";
	public String BrowserName = "Browser";
	public String browserValue = "Chrome";
	public String osName = "OS";
	public String osValue = "Windows";
	public String reportName = "Automation results Selenium";
	public String documentTitle = "Demo Website- Magneto";
	public String testTitleName = "simpletestcase/createAccount";
	public String testTitleDetails = "simpletestcase/Account is successfully created";
	public String testTitleName1 = "MediumTestcase/addProductToWishlist";
	public String testTitleDetails1 = "MediumTestcase/Product is added and removed successfully from the Wishlist";
	public String testTitleName2 = "ComplexTestcase/OrderProduct";
	public String testTitleDetails2 = "ComplexTestcase/Product is ordered successfully";
	public String discountCode = "DEAL22";

	public WebDriver initializeDriver() throws IOException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	public AddtoWishListPageObjects launchApplication() throws IOException {

		driver = initializeDriver();
		AddtoWishListPageObjects welcomeScreenObjects = new AddtoWishListPageObjects(driver);
		welcomeScreenObjects.goTo();
		return welcomeScreenObjects;
	}

}
