package com.perigon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnoroCxHomePage {

	public WebDriver driver;

	public EnoroCxHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id='app-menu']/div[6]/div[2]/div[1]/a")
	private WebElement custoemrField;

	public WebElement getcustoemrField() {

		return this.custoemrField;

	}

}
