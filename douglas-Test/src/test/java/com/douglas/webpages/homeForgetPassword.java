package com.douglas.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class homeForgetPassword {
	private WebDriver driver;
	public homeForgetPassword(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using="//a[contains(text(),'Passwort vergessen?')]") WebElement forgetPasswordLink;
	@FindBy(how=How.XPATH, using="//input[contains(@data-ui-name,'resetPassword.email')]") WebElement enterEmailTextBox;
	@FindBy(how=How.XPATH, using="//button[contains(text(),'E-Mail absenden')]") WebElement sendEmailButton;

	public void clickForgetPassword() {
		forgetPasswordLink.click();
	}

	public void setEmail(String strEmail) {
		enterEmailTextBox.sendKeys(strEmail);
	}

	public void clickEmailSendButton() {
		sendEmailButton.click();
	}
}