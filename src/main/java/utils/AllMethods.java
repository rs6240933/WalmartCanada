package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;

public class AllMethods {
	WebDriver driver;
	WebDriverWait wait;
	
	public AllMethods(WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public WebElement waitForelementpresent(By FindElement) {
		wait.until(ExpectedConditions.presenceOfElementLocated(FindElement));
		return driver.findElement(FindElement);
	}
	public void WaitTillTextPresent(By FindElement, String text) {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(FindElement, text));
	}
	
	public void WaittillvisibilityOfElementLocated(By FindElement) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindElement));
	}
	public void WaitforElementClickable(By FindElement) {
		wait.until(ExpectedConditions.elementToBeClickable(FindElement));
	}
	
	
}
