package PageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import utils.AllMethods;
import utils.Listeners;

public class OnboardStep2 extends AllMethods{
	WebDriver driver;
	public OnboardStep2(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ced-product-import")
	WebElement dropdown;

	public ArrayList<WebElement> openDropdown() {
		dropdown.click();
		ArrayList<WebElement> options = new ArrayList<WebElement>(driver.findElements(By.xpath("//select[@id='ced-product-import']/option")));
		for(int i=0; i<options.size(); i++) {
			
			Listeners.test.log(Status.INFO, options.get(i).getText());
		}
		return options;
	}

}
