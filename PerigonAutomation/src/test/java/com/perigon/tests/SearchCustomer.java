package com.perigon.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.perigon.pageobjects.EnoroCxHomePage;
import com.perigon.pageobjects.ModulePage;
import com.perigon.pageobjects.SearchCustomerPage;

public class SearchCustomer extends Base {

	public static WebDriverWait wait;
	public static ModulePage modulePage;
	public static EnoroCxHomePage homepage;
	SearchCustomerPage searchCustomer;

	@BeforeClass
	public void getPageObjects() {
		wait = new WebDriverWait(driver, 10);
		modulePage = new ModulePage(driver);
		EnoroCxHomePage homepage = new EnoroCxHomePage(driver);
		SearchCustomerPage searchCustomer = new SearchCustomerPage(driver);

	}

	@Test(priority = 2)
	public void searchCustoemr() throws InterruptedException {

		modulePage.getCustoemrCareModule().click();
		homepage.getcustoemrField().click();

		// wait.until(ExpectedConditions.elementToBeClickable(searchCustomer.getSearchBar()));
		searchCustomer.getSearchBar().sendKeys("146390");
		searchCustomer.getSearchBar().sendKeys(Keys.ENTER);

		// wait.until(ExpectedConditions.elementToBeClickable(searchCustomer.getSearchedCustomer()));

		searchCustomer.getSearchedCustomer().click();

		Thread.sleep(5000);

		String customerName = driver.findElement(By.xpath("//div[@class='meta']/span[text()='Breat Lee']")).getText();

		Assert.assertEquals(customerName, "Breat Lee", "Test Failed for searching customer");

	}

}
