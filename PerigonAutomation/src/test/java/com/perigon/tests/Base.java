package com.perigon.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.perigon.environment.Constants;
import com.perigon.pageobjects.LoginPage;
import com.perigon.utilities.PropertiesReader;

public abstract class Base {

	protected static WebDriver driver;
	protected static PropertiesReader reader;
	protected static LoginPage loginPage;

	@Parameters("browser")

	@BeforeSuite
	public void launchBrowser(@Optional("firefox") String browserName) throws IOException {

		reader = new PropertiesReader();

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sagar.sonawane\\PerigonWorkspace\\PerigonAutomation\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver();
			loginPage = new LoginPage(driver);

			driver.get(reader.getUrl());
			driver.manage().window().maximize();
			loginPage.getUserName().sendKeys(Constants.userName);
			loginPage.getPassWord().sendKeys(Constants.passWord);
			loginPage.getCheckBox().click();
			loginPage.getLoginButton().click();

			return;
		}

		else if (browserName.equalsIgnoreCase("firefox")) {

			System.out.println("set path for firefox driver");

		}

		else if (browserName.equalsIgnoreCase("ie")) {
			System.out.println("set path for ie driver");

		}

	}

	@AfterTest(enabled = true)
	public void tearDown() {

		driver.quit();

	}

}
