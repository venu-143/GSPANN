package GSPANN.Magneto;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestComponents.BaseTest;

public class DemoMagneto extends BaseTest {
	ExtentReports extent;

	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(path);
		esr.config().setReportName(reportName);
		esr.config().setDocumentTitle(documentTitle);
		esr.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(esr);
		extent.setSystemInfo(testerName, testerValue);
		extent.setSystemInfo(BrowserName, browserValue);
		extent.setSystemInfo(osName, osValue);
	}

	@Test
	public void createAccount() throws IOException, InterruptedException {

		
		ExtentTest test = extent.createTest(testTitleName);
		test.log(Status.PASS, testTitleDetails);
	
		AddtoWishListPageObjects welcomeScreenObjects = launchApplication();
		welcomeScreenObjects.createAnAccountLink.click();
		createAccountPageObjects crAccount = new createAccountPageObjects(driver);
		crAccount.customeFirstName.sendKeys(FirstName);
		crAccount.customeLastName.sendKeys(LastName);
		crAccount.checkNewspaperSubscription.click();
		Random random = new Random();
		Integer value = random.nextInt(1000);
		crAccount.customerMailId.sendKeys(emailFirst + value + emailLast);
		crAccount.customerpassword.sendKeys(customerPassword);
		crAccount.confirmPassword.sendKeys(confirmPassword);
		crAccount.createAccountButton.click();
		Assert.assertEquals( true, crAccount.successMessage.isDisplayed());
		extent.flush();
		driver.close();
	}

	@Test
	public void addProductToWishlist() throws IOException, InterruptedException {

		ExtentTest test = extent.createTest(testTitleName1);
		test.log(Status.PASS, testTitleDetails1);
		AddtoWishListPageObjects welcomeScreenObjects = launchApplication();
		AddtoWishListPageObjects homepageNavigation = new AddtoWishListPageObjects(driver);
		OrderProjectsPageObjects orderMyProduct = new OrderProjectsPageObjects(driver);
		welcomeScreenObjects.signIntoApplication(regEmailId, regPassword);
		homepageNavigation.productName.click();
		orderMyProduct.desiredSize.click();
		orderMyProduct.desiredColor.click();
		orderMyProduct.addToCartButton.click();
		Thread.sleep(3000);
		Assert.assertEquals(true, homepageNavigation.successMessage.isDisplayed());
		homepageNavigation.shoppingCartLink.click();
		homepageNavigation.moveToWishList.click();
		Assert.assertEquals( true, homepageNavigation.clearMessage.isDisplayed());
		orderMyProduct.myAccounticon.click();
		orderMyProduct.myWishListLink.click();
		WebElement we = homepageNavigation.addedProduct;
		WebElement productRemove = homepageNavigation.removeProduct;
		Actions act = new Actions(driver);
		act.moveToElement(we).moveToElement(productRemove).click().build().perform();
		Assert.assertEquals( true, homepageNavigation.successMessage.isDisplayed());
		extent.flush();
		driver.close();
	}

	@Test
	public void OrderProduct() throws IOException, InterruptedException {
		ExtentTest test = extent.createTest(testTitleName2);
		test.log(Status.PASS, testTitleDetails2);
		AddtoWishListPageObjects welcomeScreenObjects = launchApplication();
		OrderProjectsPageObjects orderMyProduct = new OrderProjectsPageObjects(driver);
		AddtoWishListPageObjects homepageNavigation = new AddtoWishListPageObjects(driver);
		welcomeScreenObjects.signIntoApplication(regEmailId, regPassword);
		orderMyProduct.desiredProduct.click();
		orderMyProduct.desiredSize.click();
		orderMyProduct.desiredColor.click();
		orderMyProduct.updateQuantity.clear();
		orderMyProduct.updateQuantity.sendKeys(quantity);
		orderMyProduct.addToCartButton.click();
		Thread.sleep(3000);
		Assert.assertEquals(true, homepageNavigation.successMessage.isDisplayed());
		orderMyProduct.cartIcon.click();
		orderMyProduct.proceedTocheckout.click();
		orderMyProduct.AddnewAddress.sendKeys(Keys.ENTER);
		orderMyProduct.shippingAddressCheckbox.click();
		Assert.assertEquals(false,orderMyProduct.shippingAddressCheckbox.isSelected());
		orderMyProduct.company.sendKeys(company);
		orderMyProduct.address.sendKeys(address);
		orderMyProduct.city.sendKeys(city);
		Select countryDropdown = new Select(orderMyProduct.country);
		countryDropdown.selectByVisibleText(country);
		Select stateDropdown = new Select(orderMyProduct.state);
		stateDropdown.selectByVisibleText(state);
		orderMyProduct.ZipCode.sendKeys(zipCode);
		orderMyProduct.phoneNumber.sendKeys(phoneNumber);
		orderMyProduct.shipHereButton.click();
		orderMyProduct.shippingMethod.click();
		orderMyProduct.nextbutton.click();
		Thread.sleep(3000);
		orderMyProduct.applyDiscountLink.click();
		orderMyProduct.enterDiscountCode.sendKeys(discountCode);
		orderMyProduct.applyDiscountConfirm.click();
		Assert.assertEquals(true, orderMyProduct.errorMessage.isDisplayed());
		orderMyProduct.placeOrderButton.sendKeys(Keys.ENTER);
		String orderNumbergenearated = orderMyProduct.orderNumber.getText();
		System.out.println(orderNumbergenearated);
		orderMyProduct.myAccounticon.click();
		orderMyProduct.myAccountLink.click();
		orderMyProduct.MyOrdersLink.click();
		String orderNumberdisplayed = orderMyProduct.OrderNumberVerify.getText();
		System.out.println(orderNumberdisplayed);
		Assert.assertEquals(orderNumbergenearated, orderNumberdisplayed);
		extent.flush();
		driver.close();

	}

}
