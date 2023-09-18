package OnboardingTest;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BasePackage.Baseclass;
import BasePackage.Listeners;
import PageObjects.OnboardObject;

public class OnboardingTest extends Baseclass {
//This is rishabh singh
	public WebDriver driver;
	public OnboardObject obj;
	@Test(priority = 1)
	public void VerificationOfSteponeUrl() throws IOException, InterruptedException {
		this.obj = LaunchApplication();
		this.driver = driverr;
		Listeners.test.log(Status.INFO, "Openneeddd");
		String url = driver.getCurrentUrl();
		String Expected_url = "https://apps.cedcommerce.com/marketplace-integration/walmartcanada/onboard/index";
		Assert.assertTrue(url.contains(Expected_url), "Wrong page is opened");

	}

	@Test(priority = 2)
	public void VerifyClickHereLink() {
		String Exurl = "https://marketplace.walmart.ca/apply/s/?source=cedcommerce";
		String currectUrl = obj.clickOnClickHere();
		Assert.assertTrue(currectUrl.contains(Exurl), "Wrong page is opened");
	}

	@Test(priority = 3)
	public void VerifyCrossButton() {
		obj.moveToWindow2();
		By el1 = By.xpath("//button[@class='Polaris-Modal-CloseButton close_polaris_modal close-modal']/span");
		WebElement element = obj.waitForelementpresent(el1);
		element.click();
	}

	@Test(priority = 4)
	public void VerifyCloseButton() {
		obj.moveToWindow2();
		driver.findElement(By.xpath("//div[@id='productmodal-header']/h2")).isDisplayed();
		driver.findElement(By.id("close-modal")).click();
	}

	@Test(priority = 5)
	public void ContactUsLinkClick() {
		obj.moveToWindow2();
		driver.findElement(By.xpath("//div[@id='productmodal-header']/h2")).isDisplayed();
	}

	@Test(priority = 6)
	public void Verifywhatsapplink() throws InterruptedException {
		By whatapplink = By.xpath("(//div[@class='Polaris-Stack__Item']/a)[2]");
		String whatsappURL = "https://chat.whatsapp.com/B94XDyYICBe7PDgVpLeQDs";
		int res[] = obj.moveToWindow2ForContactUS(whatapplink, whatsappURL);
		if (res[0] == res[1]) {
			Assert.assertTrue(false, "whatapp wrong url");
		}

	}

	@Test(priority = 7)
	public void Verifyskypelink() throws InterruptedException {
		By skype = By.xpath("(//div[@class='Polaris-Stack__Item']/a)[3]");
		String skypeURL = "https://join.skype.com/wRmnGTZbcmvo";
		int res[] = obj.moveToWindow2ForContactUS(skype, skypeURL);
		if (res[0] == res[1]) {
			Assert.assertTrue(false, "skype wrong url");
		}

	}

	@Test(priority = 8)
	public void VerifyTicketlink() {

		By ticket = By.xpath("(//div[@class='Polaris-Stack__Item']/a)[4]");
		String ticketURL = "https://support.cedcommerce.com/support/home";
		int res[] = obj.moveToWindow2ForContactUS(ticket, ticketURL);
		if (res[0] == res[1]) {
			Assert.assertTrue(false, "ticket wrong url");
		}
	}

	@Test(priority = 9)
	public void VerifyCalenderlink() {

		By calender = By.xpath("(//div[@class='Polaris-Stack__Item']/a)[5]");
		String calenderURL = "https://calendly.com/ced_walmart_expert/30min";
		int res[] = obj.moveToWindow2ForContactUS(calender, calenderURL);
		if (res[0] == res[1]) {
			Assert.assertTrue(false, "ticket wrong url");
		}

	}

	@Test(priority = 10)
	public void VerifySubmitButton() {
		obj.switchToStep1Window();
		driver.findElement(By.id("submit_btn")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='noty_body']")));

	}

	@Test(priority = 11)
	public void VerifyqueryDropDown() throws InterruptedException {
		obj.switchToStep1Window();
		obj.RefreshandWait();
		driver.findElement(By.cssSelector("strong a[class='c-pointer']")).click();
		WebElement query_type= obj.OpenDropDown();
		query_type.click();
		ArrayList<WebElement> op = new ArrayList<WebElement>(
				driver.findElements(By.xpath("//select[@id='query_type']/option")));
		Assert.assertTrue(op.get(0).getText().contains("Configuring API Key(s)"), "Configure Api is not showing");
		Assert.assertTrue(op.get(1).getText().contains("Product Importing"), "Product Importing is not showing");
		Assert.assertTrue(op.get(2).getText().contains("Profiling"), "Profiling is not showing");
		Assert.assertTrue(op.get(3).getText().contains("Other"), "Other is not showing");
	}

	@Test(priority = 12)

	public void uncheckCheckBox() throws InterruptedException {
		String nString = driver.findElement(By.xpath("//div[@class='Polaris-Page-Header__Pagination']/nav/button")).getAttribute("class");
		if(!(nString.contains("disabled"))) {
			Assert.assertTrue(false, "element enabled");
		}

	}

	@Test(priority = 13)

	public void checkCheckBox() throws InterruptedException {
	  obj.RefreshandWait();
		obj.ClickOnTermandConditions();
		String nString = driver.findElement(By.xpath("//div[@class='Polaris-Page-Header__Pagination']/nav/button")).getAttribute("class");
		if((nString.contains("disabled"))) {
			Assert.assertTrue(false, "element disabled");
		}
	}

	@Test(priority = 14)

	public void readMoreClickable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='Polaris-Button__Text'])[1]")));

	}
	@Test(priority = 15)
	public void SellerCenterClickable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://seller.walmart.ca/']")));

	}
	
	@Test(priority = 16)
	public void IfConsumeridIsgiven() throws InterruptedException {
		obj.RefreshandWait();
		String validatemsgg = obj.fillCredientials("CedCommerce007", " ");
		if((validatemsgg.contains("Secret Key cannot be blank"))){
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false, "Validation message is not showing");

		}
	}
	@Test(priority = 17)
	public void IfPrivateKeyIsgiven() throws InterruptedException {
		obj.RefreshandWait();
		String validatemsgg = obj.fillCredientials(" ", "CedCommerce008");
		if(!(validatemsgg.contains("Consumer Id cannot be blank."))){
			Assert.assertTrue(false, "Validation message is not showing");
		}
	}
	@Test(priority = 18)
	public void InvalidCredentials() throws InterruptedException {
		obj.RefreshandWait();
		String validatemsgg = obj.fillCredientials("sdwed", "wdqw2");
		if(!(validatemsgg.contains("API credentials are invalid. Please enter valid api credentials"))){
			Assert.assertTrue(false, "Validation message is not showing");
		}
	}
	
	@Test(priority = 19)
	
	public void ClickOnStoreLink() {
		driver.findElement(By.xpath("(//a[@class='color-white'])[3]")).click();
		String expectedUrl = "https://test-polaris-live.myshopify.com/password"
				+ "";
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(3));
		String currentUrl = driver.getCurrentUrl();
		driver.close();
		driver.switchTo().window(windows.get(2));
		Assert.assertTrue(currentUrl.contains(expectedUrl), "Wrong url is opened");
	}
	@Test(priority = 20)
	public void validCredentials() throws InterruptedException {
		obj.RefreshandWait();
		obj.fillBothcred("CedCommerce007", "CedCommerce008");
		obj.WaitTillTextPresent(By.xpath("//div[@class='nav-steps-wrap d-flex']/h2"),"Product Import");
		String expText = driver.findElement(By.xpath("//div[@class='nav-steps-wrap d-flex']/h2")).getText();
		Assert.assertTrue(expText.contains("Product Import"), "Wrong page is opened");
	}

}
