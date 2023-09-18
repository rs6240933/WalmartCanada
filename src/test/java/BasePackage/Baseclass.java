package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObjects.OnboardObject;

public class Baseclass{
	

	public WebDriver driverr;
	WebDriverWait wait;
	
	public void InitializeBrowser() throws IOException, InterruptedException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//property.properties");
		prop.load(fis);
		String broswername = prop.getProperty("browser");
		String runOn = prop.getProperty("RunOnNewStore");
		String store = prop.getProperty("store");
		String pass = prop.getProperty("password");
		String storeName = prop.getProperty("storeName");
		
		if (broswername.equalsIgnoreCase("chrome")) {
			this.driverr = new ChromeDriver();
			this.wait = new WebDriverWait(driverr, Duration.ofSeconds(20));
			System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
			driverr.manage().window().maximize();
			if (runOn.equalsIgnoreCase("true")) {
				runonNewStore(store, pass, storeName);
			} else {
				runonOldStore(store, pass, storeName);
			}

		}
		if (broswername.equalsIgnoreCase("firefox")) {
			this.driverr = new FirefoxDriver();
			this.wait = new WebDriverWait(driverr, Duration.ofSeconds(20));
			System.setProperty("webdriver.gecko.driver", "src//main//resources//geckodriver.exe");
			driverr.manage().window().maximize();
			if (runOn.equalsIgnoreCase("true")) {
				runonNewStore(store, pass, storeName);
			} else {
				runonOldStore(store, pass, storeName);
			}

		}
		
	}
	
	public void runonNewStore(String store, String pass, String storeName) throws InterruptedException {

		driverr.get("https://www.shopify.com/in/partners");
		driverr.findElement(By.xpath("(//a[@href='https://partners.shopify.com/organizations'])[1]")).click();
		driverr.findElement(By.id("account_email")).sendKeys(store);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
		driverr.findElement(By.cssSelector("button[type='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_password")));
		driverr.findElement(By.id("account_password")).sendKeys(pass);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
		driverr.findElement(By.cssSelector("button[type='submit']")).click();
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("(//span[@class='Polaris-Navigation__Text'])[2]")));
		driverr.findElement(By.xpath("(//span[@class='Polaris-Navigation__Text'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PolarisTextField1")));
		driverr.findElement(By.id("PolarisTextField1")).sendKeys(storeName);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='dQQabkSmBTfgBjKaboio']")));
		Thread.sleep(2000);
		driverr.findElement(By.cssSelector("button[class='dQQabkSmBTfgBjKaboio']")).click();
		Thread.sleep(8000);
		ArrayList<String> n1 = new ArrayList<String>(driverr.getWindowHandles());
		System.out.print(n1.size());

		driverr.switchTo().window(n1.get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='jb2yQ'])[2]")));
		driverr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driverr.findElement(By.xpath("(//button[@class='jb2yQ'])[2]")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='Polaris-HorizontalStack_dv6q6'])[15]")));
		driverr.findElement(By.xpath("(//div[@class='Polaris-HorizontalStack_dv6q6'])[15]")).click();
		driverr.findElement(By.xpath("(//div[@class='Polaris-Box_375yx Polaris-Box--printHidden_15ag0'])[1]/a")).click();
		Thread.sleep(3000);
		ArrayList<String> n2 = new ArrayList<String>(driverr.getWindowHandles());
		System.out.print(n2.size());
		driverr.switchTo().window(n2.get(2));
		driverr.findElement(By.xpath("(//div[@class='tw-w-full tw-relative'])[1]/input"))
				.sendKeys("CedCommerce Walmart Canada");
		driverr.navigate().to(
				"https://apps.shopify.com/walmart-canada-marketplace-integration?search_id=3b7a9fc9-0568-4018-90a9-394c92f040fb&surface_detail=walmart&surface_inter_position=1&surface_intra_position=8&surface_type=search");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@class='button_to']/button")));
		driverr.findElement(By.xpath("//form[@class='button_to']/button")).click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='Polaris-Button__Text_yj3uv'])[2]")));
		driverr.findElement(By.xpath("(//span[@class='Polaris-Button__Text_yj3uv'])[2]")).click();

	}

	public void runonOldStore(String store, String pass, String storeName) throws InterruptedException {
		driverr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driverr.get("https://www.shopify.com/in/partners");
		driverr.findElement(By.xpath("(//a[@href='https://partners.shopify.com/organizations'])[1]")).click();
		driverr.findElement(By.id("account_email")).sendKeys(store);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
		driverr.findElement(By.cssSelector("button[type='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_password")));
		driverr.findElement(By.id("account_password")).sendKeys(pass);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
		driverr.findElement(By.cssSelector("button[type='submit']")).click();
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("(//span[@class='Polaris-Navigation__Text'])[2]")));
		Thread.sleep(2000);
		driverr.findElement(By.xpath("(//span[@class='Polaris-Navigation__Text'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PolarisTextField1")));
		driverr.findElement(By.id("PolarisTextField1")).sendKeys(storeName);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='dQQabkSmBTfgBjKaboio']")));
		Thread.sleep(2000);
		driverr.findElement(By.cssSelector("button[class='dQQabkSmBTfgBjKaboio']")).click();
		Thread.sleep(8000);
		ArrayList<String> n1 = new ArrayList<String>(driverr.getWindowHandles());
		System.out.print(n1.size());

		driverr.switchTo().window(n1.get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='jb2yQ'])[2]")));
		
		driverr.findElement(By.xpath("(//button[@class='jb2yQ'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='FSndY'])[1]/div")));
		driverr.findElement(By.xpath("(//div[@class='FSndY'])[1]/div")).click();
		
		ArrayList<String> n2 = new ArrayList<String>(driverr.getWindowHandles());
		driverr.switchTo().window(n2.get(2));
		Thread.sleep(4000);
		String current_url = driverr.getCurrentUrl();
		String[] array = current_url.split("walmartcanada");
		String newUrl = array[0]+"walmartcanada/onboard/index?sHopiFy=1";
		driverr.navigate().to(newUrl);
	}
	
	public OnboardObject LaunchApplication() throws  IOException, InterruptedException {
		InitializeBrowser();
		OnboardObject obj1 = new OnboardObject(driverr);
		return obj1;
		
	}
	
	public static ExtentReports configReport() {
		// ExtentReports and ExtentSparkReporter
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("This is basic report");
		reporter.config().setReportName("Testone");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rishabh");
		return extent;
	}

}
