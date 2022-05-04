package com.perigon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModulePage {

	@FindBy(xpath = "/html/body/div[3]/div[3]/div[1]/div/div/div[1]/a/img")
	private WebElement custoemrCareModule;

	public WebDriver driver;

	public ModulePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement getCustoemrCareModule() {

		return this.custoemrCareModule;

	}

}
