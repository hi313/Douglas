// Class Definition : 

// "testWrongCredentials" --> As a user I would like to receive an error message, if I enter wrong credentials.

// Wrong credentials can also be tested with help of Excel sheet. But I did it in simpler way.

package com.douglas.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.douglas.webpages.homeLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testWrongCredentials {
	WebDriver driver;

	@Test(dataProvider="testdatacredentials")
	public void testForWrongCredentials(String loginName, String pass) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.get("https://www.douglas.de/mydouglas/login");
		driver.findElement(By.xpath("//button[contains(@class,'uc-btn-accept')]")).click();
		homeLoginPage homepage = new homeLoginPage(driver);
		homepage.setEmail(loginName);
		homepage.setPassword(pass);
		homepage.clickOnLoginButton();
		homepage.getErrorMessage();
	}

	@AfterMethod
	public void terminateBrowser() throws InterruptedException{
		Thread.sleep(2000);
		driver.close();
	}

	@DataProvider(name="testdatacredentials")
	public Object[][] TestDataCredentials() {
		Object[][] logindata = new Object[3][2];

		logindata[0][0] = "wrongEmail@t.de";
		logindata[0][1] = "hi123456";

		logindata[1][0] = "hi@mailinator.com";
		logindata[1][1] = "wrong password";

		logindata[2][0] = "wrongEmail@t.de";
		logindata[2][1] = "wrong password";

		return logindata;
	}
}
