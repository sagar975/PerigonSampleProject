package com.perigon.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.perigon.Reports.ExecutionMonitor;
import com.perigon.pageobjects.EnoroCxHomePage;
import com.perigon.pageobjects.LoginPage;
import com.perigon.pageobjects.ModulePage;
import com.perigon.pageobjects.SearchCustomerPage;
import com.perigon.utilities.ExcelUtilities;

public class TC_02_SearchCustomer extends Base {

	public static List<String> customerList;

	protected ExcelUtilities utilities;

	public static WebDriverWait wait;
	protected static ModulePage modulePage;

	protected static EnoroCxHomePage homepage;

	protected static SearchCustomerPage searchCustomer;
	protected static LoginPage loginPage;

	@BeforeClass
	public void getLoginLocator() {

		wait = new WebDriverWait(driver, 15);
		loginPage = new LoginPage(driver);
		modulePage = new ModulePage(driver);
		homepage = new EnoroCxHomePage(driver);
		searchCustomer = new SearchCustomerPage(driver);
		utilities = new ExcelUtilities();
	}

	@Test(description = "serach customers present in Excel sheet")
	public void searchFirstCustomer() throws InterruptedException {

		customerList = utilities.readExcel();
		modulePage.getCustoemrCareModule().click();

		for (int i = 0; i < customerList.size(); i++) {

			String customerNumber = customerList.get(i);
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

			wait.until(ExpectedConditions.visibilityOf(homepage.getcustoemrField()));
			homepage.getcustoemrField().click();

			searchCustomer.getSearchBar().clear();
			searchCustomer.getSearchBar().sendKeys(customerNumber);
			searchCustomer.getSearchBar().click();

			driver.findElement(By.xpath("//*[@id='global-search-input']/div[2]/div/div[2]/div/div[2]/div/div[1]"))
					.click();

			String CustomerName = driver
					.findElement(By.xpath("//*[@id=\"Details\"]/div/div[1]/div[3]/div[1]/div/div[1]/div/div/span"))
					.getText();
			// Assert.assertEquals(CustomerName, ExpectedResult.expectedCustomerName);

			System.out.println("customer name is " + CustomerName);

			Assert.assertTrue(false);

		}

	}

}
