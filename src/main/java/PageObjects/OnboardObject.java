package PageObjects;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import utils.AllMethods;


public class OnboardObject extends AllMethods {
	WebDriver driver;
	WebDriverWait wait;
	
	public OnboardObject(WebDriver driveer) {
		
		super(driveer);
		this.driver = driveer;
		this.wait = new WebDriverWait(driveer, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	public String print() {
		return "Printeed";
		
	}

	public String clickOnClickHere() {  //This will click on clickHere Link - case 1
		driver.findElement(By.xpath("//strong/a[@target='_blank']")).click();
		ArrayList<String> n3 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(n3.get(3));
		return driver.getCurrentUrl();
	}

	String expect = "https://apps.cedcommerce.com/marketplace-integration/walmartcanada/onboard/index?sHopiFy=1";

	public void moveToWindow2() {
		switchToStep1Window();
		clickonCpointer();
	}

	public void clickonCpointer() {  //This function Will EveryTime opens ContactUs Modal
		driver.findElement(By.cssSelector("strong a[class='c-pointer']")).click();
	}

	public int[] moveToWindow2ForContactUS(By FindElement, String URL) { //This func will click on whatsapp, skype etc link in contact us modal 
		switchToStep1Window();
		driver.findElement(FindElement).click();
		ArrayList<String> n4 = new ArrayList<String>(driver.getWindowHandles());
		int i = 0;
		for (i = 0; i < n4.size();) {
			driver.switchTo().window(n4.get(i));
			String getCurrenturl = driver.getCurrentUrl();
			if (!(getCurrenturl.contains(URL))) {
				i++;
			} else {
				break;
			}
		}
		int ans[] = new int[2];
		ans[0] = i;
		ans[1] = n4.size();
		return ans;
	}

	public void switchToStep1Window() { //This func. will check if current window is not step 1 then switch to step 1 window
		if (!(driver.getCurrentUrl().equals(expect))) {
			driver.close();
			ArrayList<String> p3 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(p3.get(2));

		}
	}

	public void RefreshandWait() throws InterruptedException { //This will refresh the page then waits for 2sec
		driver.navigate().refresh();
		Thread.sleep(1000);
	}

	@FindBy(xpath = "//div[@id='productmodal-header']/h2") //locator for How can we help ? in contactUS
	WebElement text;

	By dropdown = By.id("query_type"); //locator for dropdown in contactUS

	public WebElement OpenDropDown() {
		text.isDisplayed();
		WebElement n1 = waitForelementpresent(dropdown);
		return n1;
	}

	public void ClickOnTermandConditions() {
		driver.findElement(By.xpath("//span[@class='Polaris-Checkbox']")).click();
	}

	@FindBy(id = "consumer_id")
	WebElement client_id;

	public void FillCustomerId(String consumerId) {
		client_id.sendKeys(consumerId);
	}

	@FindBy(id = "secret_key")
	WebElement secret_idd;

	public void FillSecretKey(String secret_id) {
		secret_idd.sendKeys(secret_id);
	}

	By validateSecretkey = By.xpath("(//div[@class='help-block'])[2]"); //locator for secret key span message
	String validateSecretkeyText = "Secret Key cannot be blank";
	By validateClientkey = By.xpath("(//div[@class='help-block'])[1]");  //locator for client key span message
	String validateClientkeyText = "Consumer Id cannot be blank.";

	public String fillCredientials(String x, String y) { //This method will fill the invalid credientials and returns the span and validation message 
		if (y == " ") {
			FillCustomerId(x);
			ClickOnTermandConditions();
			driver.findElement(By.xpath("//div[@class='Polaris-Page-Header__Pagination']/nav/button")).click();
			WaitTillTextPresent(validateSecretkey, validateSecretkeyText);
			String validatemsg = driver.findElement(By.xpath("(//div[@class='help-block'])[2]")).getText();
			return validatemsg;
		} else if (x == " ") {
			FillSecretKey(y);
			ClickOnTermandConditions();
			driver.findElement(By.xpath("//div[@class='Polaris-Page-Header__Pagination']/nav/button")).click();
			WaitTillTextPresent(validateClientkey, validateClientkeyText);
			String validatemsg = driver.findElement(By.xpath("(//div[@class='help-block'])[1]")).getText();
			return validatemsg;
		} else {
			fillBothcred(x, y);
			String validatemsg = driver.findElement(By.xpath("(//div[@id='Banner3Content'])[2]/p")).getText();
			return validatemsg;
		}

	}

	public OnboardStep2 fillBothcred(String x, String y) { //This method will fill both valid credientials then click on Next button
		FillCustomerId(x);
		FillSecretKey(y);
		ClickOnTermandConditions();
		driver.findElement(By.xpath("//div[@class='Polaris-Page-Header__Pagination']/nav/button")).click();
		OnboardStep2 obj2 = new OnboardStep2(driver);
		return obj2;
	}
}
