package BasePackage;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class Listeners extends Baseclass implements ITestListener {
//	ExtentReports extent = reporter.configReport();
	ExtentReports extent = Baseclass.configReport();
	public static ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"failed Test");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

}
