// Class Definition : 

// "testResetPassword" --> As a user, I would like to be able to reset my password if I forget my credentials.

// Selenium can't handle captcha. While website using captcha for the same reason so no one can automate their website using any robots. 
// There is some 3rd party libraries are present who claim that they can automate captcha too but I never tried and heard that they are not efficient too. 
// Even the tesseract library does not work 100%.

// Solution : developers can provide special environment where they bypass that captcha features.

package com.douglas.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.douglas.webpages.homeForgetPassword;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testResetPassword {
	WebDriver driver;

	@BeforeTest
	public void setup(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.get("https://www.douglas.de/mydouglas/login");
		driver.findElement(By.xpath("//button[contains(@class,'uc-btn-accept')]")).click();
	}

	@Test
	public void testForResetPassword() throws InterruptedException {
		homeForgetPassword page = new homeForgetPassword(driver);
		page.clickForgetPassword();
		page.setEmail("hi@mailinator.com");
		page.clickEmailSendButton();
		Thread.sleep(2000);
		driver.close();
	}
}
