package com.perigon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	public WebDriver driver;

	@FindBy(id = "search-input")
	private WebElement searchBar;

	@FindBy(xpath = "//*[@id='global-search-input']/div[2]")
	private WebElement searchedCustomer;

	public SearchCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement getSearchBar() {

		return this.searchBar;

	}

	public WebElement getSearchedCustomer() {

		return this.searchedCustomer;

	}

}
