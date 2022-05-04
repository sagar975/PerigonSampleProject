package com.perigon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "Username")
	private WebElement userName;

	@FindBy(id = "Password")
	private WebElement passWord;

	@FindBy(xpath = "//*[@id='login-form']/div[1]/div[4]/label")
	private WebElement checkBox;

	@FindBy(css = "button.btn.login-btn.waves-effect.waves-light")
	private WebElement loginButton;

	public WebElement getUserName() {

		return userName;

	}

	public WebElement getPassWord() {

		return passWord;

	}

	public WebElement getCheckBox() {

		return checkBox;

	}

	public WebElement getLoginButton() {

		return loginButton;

	}

}
