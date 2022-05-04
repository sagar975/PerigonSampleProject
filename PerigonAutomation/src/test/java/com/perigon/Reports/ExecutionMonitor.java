package com.perigon.Reports;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.FileUtil;
import com.perigon.tests.Base;

public class ExecutionMonitor extends Base implements ITestListener {

	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extentReport;
	protected static JavascriptExecutor js;
	protected static TakesScreenshot screenShot;

	@BeforeSuite
	public void setConfiguration() {

		htmlReporter = new ExtentHtmlReporter("C://ExtentReports//results.html");
		extentReport = new ExtentReports();
		extentReport.setSystemInfo("Machine Name", "10.70.18.82");
		extentReport.setSystemInfo("Insatlled OS", System.getProperty("os.name"));
		extentReport.setSystemInfo("Installed java version", System.getProperty("java.version"));
		extentReport.setSystemInfo("Browser", "chrome");
		extentReport.setSystemInfo("Application url", reader.getUrl());
		extentReport.setSystemInfo("Application User", reader.getUserName());

	}

	public void onTestSuccess(ITestResult result) {

		extentReport.attachReporter(htmlReporter);
		ExtentTest testLogger = extentReport.createTest(result.getName());
		testLogger.log(Status.PASS, result.getName() + " " + "is passed");
		extentReport.flush();

	}

	public void onTestFailure(ITestResult result) {
		screenShot = (TakesScreenshot) driver;
		File file = screenShot.getScreenshotAs(OutputType.FILE);
		String screenShotPath = "C:\\Users\\sagar.sonawane\\PerigonWorkspace\\PerigonAutomation\\ScreenShots\\image.png";
		File destination = new File(
				"C:\\Users\\sagar.sonawane\\PerigonWorkspace\\PerigonAutomation\\ScreenShots\\image.png");

		try {
			FileHandler.copy(file, destination);

		} catch (IOException e) {

			e.printStackTrace();
		}

		extentReport.attachReporter(htmlReporter);
		ExtentTest testLogger = extentReport.createTest(result.getName());

		testLogger.log(Status.FAIL, result.getName() + " " + "is Failed");

		try {
			testLogger.addScreenCaptureFromPath(
					"C:\\Users\\sagar.sonawane\\PerigonWorkspace\\PerigonAutomation\\ScreenShots\\image.png",
					"CustomerPage");

		} catch (IOException e) {

			e.printStackTrace();
		}

		extentReport.flush();

	}

	/*
	 * @Override public boolean retry(ITestResult result) { int counter = 0;
	 * 
	 * int retryCounter = 2;
	 * 
	 * if (counter < retryCounter) { counter++; return true;
	 * 
	 * }
	 * 
	 * return false;
	 * 
	 */

}
