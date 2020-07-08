// Class Definition : 

// "testCorrectCredentialsLogin" --> As an user with correct credentials I would like to be able to login to the webshop.

package com.douglas.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.douglas.webpages.homeLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testCorrectCredentialsLogin {
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
	public void testForLogin() throws InterruptedException {		
		homeLoginPage loginpage = new homeLoginPage(driver);
		loginpage.setEmail("hi@mailinator.com");
		loginpage.setPassword("hi123456");
		loginpage.clickOnLoginButton();
		loginpage.clickOnClosePopUp();
		Thread.sleep(2000);
		String expectedTitle = "Parfümerie Douglas - Parfüm, Kosmetik, Pflege, Make-up, Düfte und Beauty-Trends bei douglas.de";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(1000);
		driver.close();
	}
}
