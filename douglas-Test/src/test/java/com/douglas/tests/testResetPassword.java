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