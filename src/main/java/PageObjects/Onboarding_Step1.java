package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Onboarding_Step1 {
	public WebDriver driver;
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	public Onboarding_Step1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String print() {
		return "Method run";
	}

//	@FindBy(xpath = "//strong/a[@target='_blank']")
//	WebElement clickHere;
//
//	public String clickOnClickHere() {
//		clickHere.click();
//		ArrayList<String> n3 = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(n3.get(3));
//		return driver.getCurrentUrl();
//	}
//
//	String expect = "https://apps.cedcommerce.com/marketplace-integration/walmartcanada/onboard/index?sHopiFy=1";
//
//	public void moveToWindow2() {
//		if (!(driver.getCurrentUrl().equals(expect))) {
//			driver.close();
//			ArrayList<String> p3 = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(p3.get(2));
//
//		}
//		clickonCpointer();
//	}
//	
//	public void clickonCpointer() {
//		driver.findElement(By.cssSelector("strong a[class='c-pointer']")).click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
//	
//	public WebElement waitForelementpresent(By FindElement) {
//		wait.until(ExpectedConditions.presenceOfElementLocated(FindElement));
//		return driver.findElement(FindElement);
//	}
}
