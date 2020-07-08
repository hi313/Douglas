package com.douglas.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class homeLoginPage {
	private WebDriver driver;
	public homeLoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using="//input[contains(@data-ui-name,'loginForm.email')]") WebElement emailTextBox;
	@FindBy(how=How.XPATH, using="//input[contains(@data-ui-name,'loginForm.password')]") WebElement passwordTextBox;
	@FindBy(how=How.XPATH, using="//button[@class='rd__button rd__button--primary rd__button--lg'][contains(.,'Einloggen')]") WebElement signinButton;
	@FindBy(how=How.XPATH, using="//div[@class='rd__modal-content__header__close']") WebElement closePopUp;
	@FindBy(how=How.XPATH, using=" //span[contains(text(),'Ihre Eingabedaten sind leider fehlerhaft, stimmen')]") WebElement errormessageText;

	public void setEmail(String strEmail) {
		emailTextBox.sendKeys(strEmail);
	}

	public void setPassword(String strPassword) {
		passwordTextBox.sendKeys(strPassword);
	}

	public void clickOnLoginButton() {
		signinButton.click();
	}

	public void clickOnClosePopUp() throws InterruptedException {
		Thread.sleep(2000);
		closePopUp.click();
	}

	public void getErrorMessage() throws InterruptedException {
		Thread.sleep(2000);
		String errorText = errormessageText.getText();
		if(errorText.equals("Ihre Eingabedaten sind leider fehlerhaft, stimmen Benutzername und Passwort?"))
		{
			System.out.println("----------Login Failed : Either Email Or Password is Incorrect -------");
		} 
		else
		{
			System.out.println("----------Login Successful ----------");
		}
	}
}