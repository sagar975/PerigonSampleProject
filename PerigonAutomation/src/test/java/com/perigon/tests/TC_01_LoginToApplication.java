package com.perigon.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.perigon.environment.Constants;
import com.perigon.environment.ExpectedResult;
import com.perigon.pageobjects.EnoroCxHomePage;
import com.perigon.pageobjects.LoginPage;
import com.perigon.pageobjects.ModulePage;
import com.perigon.pageobjects.SearchCustomerPage;
import com.perigon.utilities.ExcelUtilities;

public class TC_01_LoginToApplication extends Base {

	protected static LoginPage loginPage;

	protected static ModulePage modulePage;

	protected static EnoroCxHomePage homepage;

	protected static SearchCustomerPage searchCustomer;

	public static WebDriverWait wait;

	public static List<String> customerList;

	protected ExcelUtilities utilities;

	/*
	 * 
	 * @Test(dependsOnMethods = "loginTOApplication", description =
	 * "serach customers present in Excel sheet") public void searchFirstCustomer()
	 * throws InterruptedException {
	 * 
	 * customerList = utilities.readExcel();
	 * modulePage.getCustoemrCareModule().click();
	 * 
	 * for (int i = 0; i < customerList.size(); i++) {
	 * 
	 * String customerNumber = customerList.get(i);
	 * driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	 * 
	 * wait.until(ExpectedConditions.visibilityOf(homepage.getcustoemrField()));
	 * homepage.getcustoemrField().click();
	 * 
	 * searchCustomer.getSearchBar().clear();
	 * searchCustomer.getSearchBar().sendKeys(customerNumber);
	 * searchCustomer.getSearchBar().click();
	 * 
	 * driver.findElement(By.xpath(
	 * "//*[@id='global-search-input']/div[2]/div/div[2]/div/div[2]/div/div[1]"))
	 * .click();
	 * 
	 * String CustomerName = driver .findElement(By.xpath(
	 * "//*[@id=\"Details\"]/div/div[1]/div[3]/div[1]/div/div[1]/div/div/span"))
	 * .getText(); // Assert.assertEquals(CustomerName,
	 * ExpectedResult.expectedCustomerName);
	 * 
	 * System.out.println("customer name is " + CustomerName);
	 * 
	 * }
	 */

}
